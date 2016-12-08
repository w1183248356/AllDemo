package present;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.qpwa.qpwalib.utils.JSONUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import rx.Observable;
import wj.com.alldemo.R;

/**
 * @author wangjian
 * @title GoodsDetailsPresent
 * @description
 * @modifier
 * @date
 * @since 2016/12/8 14:01
 **/
public class GoodsDetailsPresent extends BasePresenter<GoodsDetailsActivity> {
    public static final int REQUEST_GETDETAILS = 1;
    public static final int REQUEST_PROMOTION = 2;
    public static final int REQUEST_CARSAVE = 3;
    public static final int REQUEST_SIMILARSHOP = 4;
    private Map<String, String> param;
    private Context context;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        getGoodsDetail();
        getPromotion();
        addGoodsToShopCar();
        getSimilarShop();
    }

    /**
     * 获取相同的类型的产品
     */
    private void getSimilarShop() {
        restartableFirst(REQUEST_SIMILARSHOP, () -> {
            if (param == null)
                return Observable.error(new NullPointerException("param 为Null"));
            return RESTApiImpl.productRelateds(param, null);
        }, (view, info) -> {
            if (info.getCode() == 200) {
                view.setSimilarShop(info.getData().getProducts());
            } else if (info.getCode() == 4) {
                view.hideSimilarShop();
            } else {
                Toast.makeText(context, info.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }, (view, error) -> L.ee(error.toString()));
    }

    /**
     * 商品详情
     */
    private void getGoodsDetail() {
        restartableFirst(REQUEST_GETDETAILS, () -> {
            if (param == null)
                return Observable.error(new NullPointerException("param 为Null"));
            return RESTApiImpl.productGetdetail(param, PBUtil.getPD(context));
        }, (view, productDetailInfo) -> {
            if (productDetailInfo.getCode() == 200) {
                try {
                    view.initView(productDetailInfo);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            } else {
                view.initErrorView(productDetailInfo.getMsg());
            }

        }, (view, error) -> L.ee(error.toString()));
    }

    /**
     * 获取促销商品的信息
     */
    private void getPromotion() {
        restartableFirst(REQUEST_PROMOTION, () -> {
            if (param == null)
                return Observable.error(new NullPointerException("param 为Null"));
            return RESTApiImpl.webpromGetstkcprom(param, PBUtil.getPD(context));
        }, (view, promotionInfo) -> {
            try {
                if (promotionInfo.getCode() == NetCodeStatus.OK) {
                    JSONObject jsonObject = promotionInfo.getData();
                    List<PromotionInfo> listA = new ArrayList<>();
                    List<PromotionInfo> listB = new ArrayList<>();
                    List<PromotionInfo> listE = new ArrayList<>();
                    List<PromotionInfo> listCombo = new ArrayList<>();
                    if (jsonObject.has("ALIST")) {
                        listA = JSONUtils.fromJsonArray(jsonObject.getJSONArray("ALIST").toString(), new TypeToken<List<PromotionInfo>>() {
                        });
                    }
                    if (jsonObject.has("BLIST")) {
                        listB = JSONUtils.fromJsonArray(jsonObject.getJSONArray("BLIST").toString(), new TypeToken<List<PromotionInfo>>() {
                        });

                    }
                    if (jsonObject.has("CLIST")) {
                        listCombo.addAll(JSONUtils.fromJsonArray(jsonObject.getJSONArray("CLIST").toString(), new TypeToken<List<PromotionInfo>>() {
                        }));
                    }
                    if (jsonObject.has("ELIST")) {
                        listE = JSONUtils.fromJsonArray(jsonObject.getJSONArray("ELIST").toString(), new TypeToken<List<PromotionInfo>>() {
                        });
                    }
                    view.initPromotionList(listA, listB, listE, listCombo);
                } else if (promotionInfo.getCode() == 4) {
                    view.hidePromotion();
                } else {
                    Toast.makeText(context, promotionInfo.getMsg(), Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, (view, error) -> L.ee(error.toString()));
    }

    /**
     * 添加商品到购物车
     */
    private void addGoodsToShopCar() {
        restartableFirst(REQUEST_CARSAVE, () -> {
            if (param == null)
                return Observable.error(new NullPointerException("param 为Null"));
            return RESTApiImpl.cartSave(param, PBUtil.getPD(context));
        }, (view, info) -> {
            if (info.getCode() == NetCodeStatus.OK) {
                Toast.makeText(context, R.string.addd_cart_succ, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, info.getMsg().toString(), Toast.LENGTH_SHORT).show();
            }


        }, (view, error) -> L.ee(error.toString()));
    }

    public void request(Map<String, String> map, Context context, int requestId) {
        this.param = map;
        this.context = context;
        start(requestId);
    }
}
