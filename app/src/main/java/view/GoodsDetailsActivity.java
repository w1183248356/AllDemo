package view;

import interfaces.OnStandardChangeListener;
import nucleus.factory.RequiresPresenter;
import present.GoodsDetailsPresent;
import wj.com.BaseNucleusActivity;

@RequiresPresenter(GoodsDetailsPresent.class)
public class GoodsDetailsActivity extends BaseNucleusActivity<GoodsDetailsPresent> implements OnStandardChangeListener {
    @Override
    public void onStandardChange(String standard, String stkc, int count, String price) {

    }

    @Override
    public void onStandardWindowClose(String stkc) {

    }
    //    /**
//     * 传递过来的id号
//     */
//    public static String SHOPNUM = "shopNum";
//    /**
//     * 传递过来的购买数量
//     */
//    public static String SHOPBUYCONUT = "shopCount";
//    /**
//     * 传递过来的促销主id号
//     */
//    public static String MAS_PK_NO = "MAS_PK_NO";
//    /**
//     * 促销明细的idKey
//     */
//    public static String ITEM_PK_NO = "ITEM_PK_NO";
//    /**
//     * 普通的类型
//     */
//    private final int common = 0;
//    //促销明细的id
//    public String item_pk_no = "";
//    //保存促销方案id
//    public String mas_pk_no = "";
//    @Bind(R.id.ac_goods_bottom)
//    RelativeLayout mGoodsBottom;
//    @Bind(R.id.ac_goods_slider)
//    SliderLayout acGoodsSlider;
//    @Bind(R.id.ac_goods_details_tv_name)
//    TextView mGoodsName;
//    @Bind(R.id.ac_goods_details_tv_desc)
//    TextView mGoodsDesc;
//    @Bind(R.id.ac_goods_details_tv_newprice)
//    TextView mGoodsNewprice;
//    @Bind(R.id.ac_goods_details_tv_oldprice)
//    TextView mGoodsOldprice;
//    @Bind(R.id.view_check_goods_reduce)
//    TextView mGoodsReduce;
//    @Bind(R.id.view_check_goods_num)
//    TextView mGoodsNum;
//    @Bind(R.id.view_check_goods_add)
//    TextView mGoodsAdd;
//    @Bind(R.id.ac_goods_details_countdown)
//    CountdownView mGoodsCountdown;
//    @Bind(R.id.title_left_bt)
//    ImageButton mTitleLeft;
//    @Bind(R.id.title_text_tv)
//    TextView mTitleText;
//    @Bind(R.id.promd_layout)
//    RelativeLayout mPromdLayout;
//    //@Bind(R.id.ac_goods_detals_sale_contents)
//    //TextView mSaleContents;
//    @Bind(R.id.ac_goods_details_sale_rl)
//    RelativeLayout mSaleRl;
//    @Bind(R.id.ac_shopinfo_sales_promotion_ly)
//    LinearLayout mSalesPromotion_Ly;
//    @Bind(R.id.ac_goods_details_send_icon)
//    TextView mSendIcon;//单品买赠
//    @Bind(R.id.ac_goods_details_send1_icon)
//    TextView mSend1Icon;//混搭买赠
//    @Bind(R.id.ac_goods_details_sale_icon)
//    TextView mSaleIcon;//打折促销
//    @Bind(R.id.ac_goods_details_favorable_icon)
//    TextView mFavorableIcon;//优惠套餐
//    @Bind(R.id.ac_shop_info_addshopcar_bt)
//    TextView mBuyGoods;
//    @Bind(R.id.ac_shop_info_chat_bt)
//    TextView mContact;
//    @Bind(R.id.title_right_bt)
//    Button mTitleRight;
//    @Bind(R.id.title_message_num)
//    TextView mTitleNum;
//    @Bind(R.id.ac_goods_details_tv_cheap)
//    TextView acGoodsDetailsTvCheap;
//    @Bind(R.id.ac_goods_details_sale_tip)
//    TextView acGoodsDetailsSaleTip;
//    @Bind(R.id.ac_goods_details_standard)
//    TextView mStandard;
//    @Bind(R.id.goods_details_goto_shopcar_btn)
//    TextView mGotoShopCar;
//    @Bind(R.id.ac_shop_info_hot_shopinfo_tv)
//    TextView mHotShopInfo;
//    @Bind(R.id.ac_shop_info_hot_recycler_rc)
//    RecyclerView mRecyclerView;
//    @Bind(R.id.similar_shop_ll)
//    LinearLayout mSimolarShopLl;
//    @Bind(R.id.ac_goods_details_timer_des)
//    TextView mTimeDes;
//    @Bind(R.id.title_message_fl)
//    FrameLayout flMessage;
//    @Bind(R.id.ac_goods_details_error_tv)
//    TextView mErrTv;
//    @Bind(R.id.ac_goods_details_sv)
//    ScrollView mScrollView;
//    //底部提示语
//    @Bind(R.id.ac_goods_detals_sale_out_tv)
//    TextView mSaleOutFlag;
//    @Bind(R.id.ac_goods_details_coupons_rl)
//    RelativeLayout mCouponsRl;
//    /**
//     * 设置界面
//     *
//     * @param info
//     */
//
//    ProductDetailInfo.ProductBean productBean;
//    List<CustomService.DataBean.ResultListBean> customServices = null;
//    private List<NewCouponInfo.DataBean.CouponInfo> couponsInfos = new ArrayList<>();
//    //活动弹窗
//    private GoodsPromotionPopupWindow popupMenu;
//    //属性规格弹窗
//    private StandardWindow mPopupWindow;
//    /**
//     * 商品 id  （传递过来）
//     */
//    private String mShopNum;
//    /**
//     * 商品 购买数量（传递过来）
//     */
//    private String mShopBuyCount;
//    /**
//     * 相同产品的数据源
//     */
//    private List<ProductsInfo.DataBean.ProductBean> mSeemShop = new ArrayList<>();
//    /**
//     * 相关商品的适配器
//     */
//    private HotShopAdapter mHotAdapter;
//    private String serveice;
//    /**
//     * 最低抢购金额
//     */
//    private double minNeed;
//    /**
//     * 剩余库存
//     */
//    private float mGoodsLeftNum;
//    /**
//     * 判断用户是否有资格购买该商品
//     */
//    private String allowFlg;
//    private RecyclerView dialogCoupons;
//    /**
//     * 优惠卷的Dialog
//     */
//    private Dialog mCouponsDialog;
//    private GetCouponsAdapter mGetCouponsAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_goods_details);
//        ButterKnife.bind(this);
//        mShopNum = getIntent().getStringExtra(SHOPNUM);
//        mas_pk_no = getIntent().getStringExtra(MAS_PK_NO);
//        item_pk_no = getIntent().getStringExtra(ITEM_PK_NO);
//        mShopBuyCount = getIntent().getStringExtra(SHOPBUYCONUT);
//        if (TextUtils.isEmpty(mShopBuyCount)) {
//            mShopBuyCount = "0";
//        }
//        getProductDetailData(mShopNum, item_pk_no, mas_pk_no);
//        getPromotion();
//        flMessage.setVisibility(View.VISIBLE);
//        showChatCount();
//        /*mTitleRight.setVisibility(View.GONE);
//        mTitleRight.setText("评论");*/
//        mTitleText.setText("商品详情");
//        mGoodsNum.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                try {
//                    if (!TextUtils.isEmpty(s.toString()) && Integer.valueOf(s.toString()) == 1) {
//                        mGoodsReduce.setTextColor(0xff999999);
//                        mGoodsAdd.setTextColor(0xffff9d00);
//                    } else if (!TextUtils.isEmpty(s.toString()) && Integer.valueOf(s.toString()) == mGoodsLeftNum) {
//                        mGoodsReduce.setTextColor(0xffff9d00);
//                        mGoodsAdd.setTextColor(0xff999999);
//                    } else {
//                        mGoodsReduce.setTextColor(0xffff9d00);
//                        mGoodsAdd.setTextColor(0xffff9d00);
//                    }
//                } catch (NumberFormatException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
//    @Override
//    protected void onDestroy() {
//        setResult(RESULT_OK);
//        super.onDestroy();
//    }
//
//    /**
//     * 获取相同的类型的产品
//     */
//    private void getSimilarShop(ProductDetailInfo.ProductBean info) {
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("stkc", info.shopNum);
//        map.put("areaid", UserBusiness.getUserAreaID());
//        getPresenter().request(map, this, GoodsDetailsPresent.REQUEST_SIMILARSHOP);
//    }
//
//    /**
//     * 商品详情接口
//     * 当前属性不参加活动时 下面2个字段置空
//     * item_pk_no
//     * mas_pk_no
//     */
//    private void getProductDetailData(String stkc, String item_pk_no, String mas_pk_no) {
//        HashMap params = new HashMap<>();
//        params.put("stkc", stkc);
//        params.put("itempkno", item_pk_no);
//        params.put("maspkno", mas_pk_no);
//        params.put("userno", UserBusiness.getUserId());
//        params.put("username", UserBusiness.getAccountNum());
//        params.put("areaid", UserBusiness.getUserAreaID());
//        getPresenter().request(params, this, GoodsDetailsPresent.REQUEST_GETDETAILS);
//    }
//
//    /**
//     * 获取促销的方案
//     */
//    private void getPromotion() {
//        HashMap params = new HashMap<>();
//        params.put("stkc", mShopNum);
//        params.put("areaid", UserBusiness.getUserAreaID());
//        params.put("username", UserBusiness.getAccountNum());
//        if (!TextUtils.isEmpty(item_pk_no)) {
//            params.put("itempkno", item_pk_no);
//        }
//        getPresenter().request(params, this, GoodsDetailsPresent.REQUEST_PROMOTION);
//    }
//
//    /***
//     * 获取到相同产品的后赋值
//     */
//    public void setSimilarShop(final List<ProductsInfo.DataBean.ProductBean> infos) {
//        mSeemShop.addAll(infos);
//        mSimolarShopLl.setVisibility(View.VISIBLE);
//        mHotAdapter = new HotShopAdapter(mSeemShop, this);
//        mHotAdapter.setOnItemClickListener(new OnRecyclerViewItemClickListener<ProductsInfo.DataBean.ProductBean>() {
//            @Override
//            public void onItemClick(View view, ProductsInfo.DataBean.ProductBean shopInfo) {
//                Intent it = new Intent(GoodsDetailsActivity.this, GoodsDetailsActivity.class);
//                it.putExtra(SHOPNUM, shopInfo.shopNum);
//                it.putExtra(SHOPBUYCONUT, 1);
//                startActivity(it);
//                finish();
//            }
//        });
//        mHotAdapter.setListener(new HotShopAdapter.AddShopCartClick() {
//            @Override
//            public void onClick(ProductsInfo.DataBean.ProductBean info) {
//                if (UserBusiness.isLogin()) {
//                    HashMap<String, String> map = new HashMap<String, String>();
//                    map.put("pkno", "");
//                    map.put("userid", UserBusiness.getUserId());
//                    map.put("cartkey", "");
//                    map.put("stkc", info.shopNum);
//                    map.put("buynum", "1");
//                    getPresenter().request(map, GoodsDetailsActivity.this, GoodsDetailsPresent.REQUEST_CARSAVE);
//                } else {
//                    startLoginActivity();
//                }
//            }
//        });
//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        mRecyclerView.setLayoutManager(manager);
//        mRecyclerView.setAdapter(mHotAdapter);
//
//    }
//
//    public void hideSimilarShop() {
//        mSimolarShopLl.setVisibility(View.GONE);
//    }
//
//    public void initPromotionList(List<PromotionInfo> listA, List<PromotionInfo> listB, List<PromotionInfo> listE, List<PromotionInfo> listCombo) {
//        List<PromotionInfo> listPro = new ArrayList<>();
//
//        if (listA != null && listA.size() > 0) {
//            mSaleIcon.setVisibility(View.VISIBLE);
//            listPro.addAll(listA);
//        }
//        if (listB != null && listB.size() > 0) {
//            mSendIcon.setVisibility(View.VISIBLE);
//            listPro.addAll(listB);
//        }
//        if (listE != null && listE.size() > 0) {
//            mSend1Icon.setVisibility(View.VISIBLE);
//            listPro.addAll(listE);
//        }
//
//        if (listCombo != null && listCombo.size() > 0) {
//            mFavorableIcon.setVisibility(View.VISIBLE);
//        }
//        if (listA.size() == 0 && listB.size() == 0 && listE.size() == 0 && listCombo.size() == 0) {
//            hidePromotion();
//        } else {
//            showPromotion();
//        }
//        popupMenu = new GoodsPromotionPopupWindow(GoodsDetailsActivity.this, listPro, listCombo);
//    }
//
//    public void hidePromotion() {
//        mSaleRl.setVisibility(View.GONE);
//    }
//
//    public void showPromotion() {
//        mSaleRl.setVisibility(View.VISIBLE);
//    }
//
//    private void getGoodsLeftNum(ProductDetailInfo info) {
//        /*if (!TextUtils.isEmpty(info.getProduct().singleCustQty)) {
//            mGoodsLeftNum = Integer.valueOf(info.getProduct().singleCustQty);
//        } else {
//            mGoodsLeftNum = Integer.valueOf(info.getProduct().goodsNum);
//        }*/
//
//        mGoodsLeftNum = info.getProduct().goodsNum;
//        mGoodsNum.setText(mGoodsLeftNum <= 0 ? "1" : "1");
//        mGoodsNum.setText(mGoodsLeftNum <= 0 ? "1" : "1");
//    }
//
//    private void initSlide(List<String> urls) {
//        Observable.from(urls).subscribe(url -> {
//            TextSliderView textSliderView = new TextSliderView(this);
//            textSliderView
//                    .image(url)
//                    .setScaleType(BaseSliderView.ScaleType.CenterInside);
//            //add your extra information
//
//            acGoodsSlider.addSlider(textSliderView);
//        });
//        //acGoodsSlider.setPresetTransformer(SliderLayout.Transformer.Default);
//        acGoodsSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
//        acGoodsSlider.startAutoCycle(4000, 4000, true);
//    }
//
//    public void initErrorView(String msg) {
//        mScrollView.setVisibility(View.GONE);
//        mErrTv.setVisibility(View.VISIBLE);
//        mErrTv.setText(msg);
//        //mTitleText.setText(msg);
//        mGoodsBottom.setVisibility(View.GONE);
//    }
//
//    public void initView(ProductDetailInfo info) {
//        mScrollView.setVisibility(View.VISIBLE);
//        mErrTv.setVisibility(View.GONE);
//        mGoodsBottom.setVisibility(View.VISIBLE);
//        productBean = info.getProduct();
//
//        //productBean = new Gson().fromJson(ProductDetails, ProductDetailInfo.ProductBean.class);
//        //获取商家号
//        //获取客服列表
//        Map<String, String> params = new HashMap<>();
//        params.put("vendorUserName", getvendorUserName());
//        RESTApiImpl.findsalesmen(params, null).subscribe(customService -> {
//            if (customService.getCode() == NetCodeStatus.OK) {
//                if (customService.getData().getResultList() == null || customService.getData().getResultList().size() == 0) {
//                    mContact.setVisibility(View.GONE);
//                } else {
//                    mContact.setVisibility(View.VISIBLE);
//                    customServices = customService.getData().getResultList();
//                }
//            }
//        }, e -> Toast.makeText(GoodsDetailsActivity.this, R.string.error_server, Toast.LENGTH_SHORT).show());
//        getGoodsLeftNum(info);
//        if (info.getProduct().urlList != null)
//            initSlide(info.getProduct().urlList);
//        if (TextUtils.isEmpty(info.getProduct().modle)) {
//            mGoodsName.setText(info.getProduct().shopName);
//        } else {
//            mGoodsName.setText(info.getProduct().shopName + info.getProduct().modle);
//        }
//        mGoodsDesc.setText(info.getProduct().exp);
//        mGoodsNewprice.setText(String.format("¥%1$.2f", info.getProduct().price));
//        mGoodsOldprice.setText(String.format("¥%1$.2f", info.getProduct().oldPrice));
//        mGoodsOldprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
//        mGoodsOldprice.getPaint().setAntiAlias(true);// 抗锯齿
//        serveice = info.getProduct().serveice;
//        getSimilarShop(info.getProduct());
//        if (info.getProduct().goodsNum <= 0) {
//            mBuyGoods.setEnabled(false);
//            mBuyGoods.setText("加入购物车");
//            mSaleOutFlag.setVisibility(View.VISIBLE);
//        } else {
//            mBuyGoods.setEnabled(true);
//            mBuyGoods.setText("加入购物车");
//        }
//
//        /***
//         * 添加促销的商品
//         */
//        if (PromotionInfo.PRESENTATION.equals(info.getProduct().masCode)) {
//            addViewPresent(info, PromotionInfo.PRESENTATION);//单品买赠添加赠品的方案；
//        } else if (PromotionInfo.PRESENTATION_E.equals(info.getProduct().masCode)) {
//            addViewPresent(info, PromotionInfo.PRESENTATION_E);//混搭买赠添加赠品的方案；
//        } else if (PromotionInfo.DISCOUNT.equals(info.getProduct().masCode)) {
//            addViewDiscount(info);//添加打折的方案；
//        } else if (PromotionInfo.PURCHASE.equals(info.getProduct().masCode)) {
//            addPurchase(info);//添加抢购
//        } else {
//            mSalesPromotion_Ly.removeAllViews();
//        }
//        if (info.getProduct().goodsNum == -1) {
//            mBuyGoods.setEnabled(false);
//            mBuyGoods.setText("活动已删除");
//        } else if (!TextUtils.isEmpty(info.getProduct().type) && (info.getProduct().type.equals("A") || info.getProduct().type.equals("F"))) {
//            mBuyGoods.setEnabled(false);
//            mBuyGoods.setText("活动结束");
//        } else if (!TextUtils.isEmpty(info.getProduct().type) && info.getProduct().type.equals("W")) {
//            mBuyGoods.setEnabled(false);
//            mBuyGoods.setText("商品不存在");
//        }
//
//
//        //判断是否是活动 leftMaxqty判断活动库存
//        if (!TextUtils.isEmpty(mas_pk_no)) {
//            if (info.getProduct().minQty <= 0) {
//                mBuyGoods.setEnabled(false);
//                mBuyGoods.setText("加入购物车");
//                mSaleOutFlag.setText("商品已售完");
//                mSaleOutFlag.setVisibility(View.VISIBLE);
//            }
//        }
//
//        allowFlg = info.getProduct().ALLOW_FLG;
//        if (allowFlg == null || allowFlg.equals("N")) {
//            mSaleOutFlag.setText("此商品不可购买");
//            mSaleOutFlag.setVisibility(View.VISIBLE);
//            mBuyGoods.setEnabled(false);
//        }
//
//        if (info.getProduct().couponInfos != null && info.getProduct().couponInfos.size() > 0) {
//            couponsInfos.clear();
//            couponsInfos.addAll(info.getProduct().couponInfos);
//            initCouponsDialog(info.getProduct().couponInfos);
//            mCouponsRl.setVisibility(View.VISIBLE);
//        } else {
//            mCouponsRl.setVisibility(View.GONE);
//        }
//
//
//        //初始化属性规格
//        int screenHeight = getWindowManager().getDefaultDisplay().getHeight();
//        int popupwindowHeight = screenHeight * 8 / 10;
//        mPopupWindow = new StandardWindow(this, popupwindowHeight, screenHeight, productBean, this);
//        mPopupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
//        mPopupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
//        //设置默认属性
//        mStandard.setText(mPopupWindow.getNameWithCheckedStandard());
//
//    }
//
//
//    /**
//     * 添加抢购方案
//     *
//     * @param info
//     */
//    private void addPurchase(ProductDetailInfo info) {
//        //设置抢购倒计时
//        if (info.getProduct().promd != null) {
//            mGoodsCountdown.setTag("CountDown");
//            acGoodsDetailsTvCheap.setText(("订单金额满足" + info.getProduct().promd.minAmtNeed + "元即可抢购此商品\n每人限购" + info.getProduct().singleCustQty + info.getProduct().uom).toString().trim());
//            long time = 0;
//            mGoodsCountdown.setOnCountdownEndListener(cv -> getProductDetailData(mShopNum, item_pk_no, mas_pk_no));
//            mPromdLayout.setVisibility(View.VISIBLE);
//            minNeed = info.getProduct().promd.minAmtNeed;
////            if (Long.valueOf(info.getProduct().promd.endS) >= 0) {
////                mBuyGoods.setEnabled(false);
////                mBuyGoods.setText("抢购已结束");
////            }
//            if (info.getProduct().promd.startS < 0) {//未开始
//                mBuyGoods.setEnabled(false);
//                mBuyGoods.setText("抢购未开始");
//                mTimeDes.setText("距离抢购开始");
//                time = Math.abs(info.getProduct().promd.startS) * 1000;
//            } else if (info.getProduct().promd.startS >= 0 && info.getProduct().promd.endS < 0) {//已开始
//                time = Math.abs(info.getProduct().promd.endS) * 1000;
//                if (Integer.valueOf(info.getProduct().singleCustQty) <= 0) {//已抢完
//                    mBuyGoods.setText("已抢光");
//                    mBuyGoods.setEnabled(false);
//                } else {
//                    mBuyGoods.setText("加入购物车");
//                    mBuyGoods.setEnabled(true);
//                }
//                mTimeDes.setText("距离抢购结束");
//            } else if (info.getProduct().promd.endS > 0) {//已结束
//                mBuyGoods.setEnabled(false);
//                mBuyGoods.setText("抢购已结束");
//                time = 0;
//                mTimeDes.setText("距离抢购结束");
//            }
//
//            mGoodsCountdown.start(time);
//        } else {
//            mPromdLayout.setVisibility(View.GONE);
//        }
//    }
//
//    //添加打折的方案；
//    private void addViewDiscount(ProductDetailInfo mShopInfo) {
//        View vone = LayoutInflater.from(this).inflate(R.layout.item_donation_list_one, null);
//        TextView name_tv = (TextView) vone.findViewById(R.id.item_donation_nameone_tv);
//        TextView type_tv = (TextView) vone.findViewById(R.id.item_donation_typeone_iv);
//        name_tv.setText(mShopInfo.getProduct().refNo + "(每人限购" + mShopInfo.getProduct().singleCustQty + "件)");
//        type_tv.setText("打折促销");
//        mSalesPromotion_Ly.addView(vone);
//    }
//
//    //添加赠品的方案
//    private void addViewPresent(ProductDetailInfo mShopInfo, String type) {
//        View vone = LayoutInflater.from(this).inflate(R.layout.item_donation_list_one, null);
//        TextView name_tv = (TextView) vone.findViewById(R.id.item_donation_nameone_tv);
//        TextView type_tv = (TextView) vone.findViewById(R.id.item_donation_typeone_iv);
//        if (type.equals(PromotionInfo.PRESENTATION)) {
//            name_tv.setText(mShopInfo.getProduct().refNo + "(条件:购买" + mShopInfo.getProduct().baseQty + "件以上)");
//            type_tv.setText("单品买赠");
//        } else if (type.equals(PromotionInfo.PRESENTATION_E)) {
//            if (!TextUtils.isEmpty(mShopInfo.getProduct().limitNum) && Integer.parseInt(mShopInfo.getProduct().limitNum) > 0) {
//                name_tv.setText(mShopInfo.getProduct().refNo + "(条件:拼单满" + mShopInfo.getProduct().wpmBaseQty + "件送赠品，每人限参与" + mShopInfo.getProduct().limitNum + "次)");
//            } else {
//                name_tv.setText(mShopInfo.getProduct().refNo + "(条件:拼单满" + mShopInfo.getProduct().wpmBaseQty + "件送赠品,不限次数)");
//            }
//            type_tv.setText("混搭买赠");
//        }
//
//        mSalesPromotion_Ly.addView(vone);
//        for (int i = 0; i < mShopInfo.getProduct().list.size(); i++) {
//            final ProductDetailInfo.ProductBean.Giveaway p = mShopInfo.getProduct().list.get(i);
//            View vtwo = LayoutInflater.from(this).inflate(R.layout.item_donation_list_two, null);
//            TextView name_two_tv = (TextView) vtwo.findViewById(R.id.item_donation_nametwo_tv);
//            TextView tvQTY = (TextView) vtwo.findViewById(R.id.tvQTY);
//            name_two_tv.setText(mShopInfo.getProduct().list.get(i).name);
//            if (TextUtils.isEmpty(p.atpQty) || Integer.parseInt(p.atpQty) < p.stkQty) {
//                tvQTY.setText("已赠完");
//            } else {
//                tvQTY.setText("x" + p.stkQty + "(" + p.uom + ")");
//            }
//            name_two_tv.setOnClickListener(v -> {
//                        Intent it = new Intent(GoodsDetailsActivity.this, GoodsDetailsActivity.class);
//                        it.putExtra(GoodsDetailsActivity.SHOPNUM, p.stkC);
//                        it.putExtra(GoodsDetailsActivity.SHOPBUYCONUT, 1);
//                        startActivity(it);
//                    }
//            );
//            mSalesPromotion_Ly.addView(vtwo);
//        }
//
//
//    }
//
//    private void showChatCount() {
//        int count = 0;
//        Map<String, EMConversation> conversations = EMClient.getInstance().chatManager().getAllConversations();
//        for (Map.Entry<String, EMConversation> entry : conversations.entrySet()) {
//            count = count + entry.getValue().getUnreadMsgCount();
//        }
//        if (count == 0) {
//            mTitleNum.setVisibility(View.INVISIBLE);
//            return;
//        } else {
//            mTitleNum.setVisibility(View.VISIBLE);
//        }
//
////        if (count >= 100) {
////            mTitleNum.setText("99+");
////        } else {
////            mTitleNum.setText("" + count);
////        }
//    }
//
//    @Subscribe
//    public void onChangeMeaageNumEvent(EventBusInfo eventBusInfo) {
//        if (eventBusInfo.getType().equals(EventBusType.CHATNUMBER)) {
//            showChatCount();
//        }
//    }
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            if (popupMenu != null && popupMenu.popupWindow != null && popupMenu.popupWindow.isShowing()) {
//                popupMenu.dissmiss();
//                return true;
//            }
//            setResult(RESULT_OK);
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//
//    @OnClick({R.id.title_left_bt, R.id.title_text_tv, R.id.view_check_goods_reduce, R.id.view_check_goods_num,
//            R.id.view_check_goods_add, R.id.ac_goods_details_sale_rl,
//            R.id.ac_shop_info_addshopcar_bt, R.id.ac_shop_info_chat_bt, R.id.goods_details_goto_shopcar_btn,
//            R.id.ac_shop_detail_evaluate_ll, R.id.title_message_fl, R.id.ac_goods_details_coupons_rl, R.id.ac_goods_details_standard})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.title_left_bt:
//                setResult(RESULT_OK);
//                finish();
//                break;
//
//            case R.id.view_check_goods_reduce:
//                if (UserBusiness.isLogin()) {
//                    //     BigInteger num = new BigInteger(mGoodsNum.getText().toString());
//                    int num = Integer.parseInt(mGoodsNum.getText().toString());
////                    if (num.compareTo(new BigInteger("1")) == 1) {
////                        num.subtract(new BigInteger("1"));
////                        mGoodsNum.setText(num.toString());
////                    }
//                    if (num > 1) {
//                        num--;
//                        mGoodsNum.setText(String.valueOf(num));
//                    }
//                } else {
//                    startLoginActivity();
//                }
//                break;
//            case R.id.view_check_goods_num:
//                if (UserBusiness.isLogin()) {
//                    if (Integer.parseInt(mGoodsNum.getText().toString().trim()) <= 0) {
//                        Toast.makeText(this, "库存不足", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//                    final BuyCountDialog dialog = new BuyCountDialog(this, mGoodsLeftNum);
//                    dialog.show();
//                    dialog.setBuyNum(Integer.parseInt(mGoodsNum.getText().toString().trim()));
//                    dialog.setListener(num -> mGoodsNum.setText(num));
//                } else {
//                    startLoginActivity();
//                }
//                break;
//            case R.id.view_check_goods_add:
//                if (UserBusiness.isLogin()) {
//                    int i = Integer.parseInt(mGoodsNum.getText().toString());
//                    if (i < mGoodsLeftNum) {
//                        i++;
//                        mGoodsNum.setText(String.valueOf(i));
//                    } else {
//                        Toast.makeText(GoodsDetailsActivity.this, "商品库存量为" + mGoodsLeftNum, Toast.LENGTH_SHORT).show();
//                    }
////                    BigInteger i=new BigInteger(mGoodsNum.getText().toString());
////                    if(i.compareTo(new BigInteger(String.valueOf(mGoodsLeftNum)))!=1){
////                        i.add(new BigInteger("1"));
////                        mGoodsNum.setText(i.toString());
////                    }else {}
//                } else {
//                    startLoginActivity();
//                }
//                break;
//            case R.id.ac_goods_details_sale_rl:
//                if (popupMenu != null) {
//                    popupMenu.showPopWindow(findViewById(R.id.ac_shopinfo_parent));
//                }
//                break;
//
//            case R.id.ac_shop_info_addshopcar_bt:
//                if (allowFlg == null || allowFlg.equals("N")) {
//                    Toast.makeText(this, "此商品不可购买", Toast.LENGTH_LONG).show();
//                    return;
//                }
//
//                if (UserBusiness.isLogin()) {
//                    if (mShopNum == null) {
//                        Toast.makeText(this, "请先选择相关属性", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//
//                    HashMap<String, String> map = new HashMap<>();
//                    map.put("pkno", "");
//                    map.put("userid", UserBusiness.getUserId());
//                    map.put("cartkey", "");
//                    if (!TextUtils.isEmpty(item_pk_no) && !TextUtils.isEmpty(mas_pk_no)) {
//                        map.put("itempkno", item_pk_no);
//                        map.put("maspkno", mas_pk_no);
//                    }
//                    map.put("stkc", mShopNum);
//                    map.put("buynum", mGoodsNum.getText().toString().trim());
//                    getPresenter().request(map, this, GoodsDetailsPresent.REQUEST_CARSAVE);
//                } else {
//                    startLoginActivity();
//                }
//                break;
//
//            case R.id.ac_shop_info_chat_bt:
//                CheckServiceDialog dialog = new CheckServiceDialog();
//                Bundle bundle = new Bundle();
//                bundle.putString("vendorUserName", getvendorUserName());
//                bundle.putSerializable("customServices", (Serializable) customServices);
//                dialog.setArguments(bundle);
//                dialog.show(getFragmentManager(), "客服");
//                break;
//            case R.id.goods_details_goto_shopcar_btn:
//                EventBusInfo info = new EventBusInfo(EventBusType.CHANGEFRAGMENT, "" + 2);
//                EventBus.getDefault().post(info);
//                ((App) getApplicationContext()).backToIndexActivity();
//                break;
//            case R.id.ac_shop_detail_evaluate_ll:
//                Intent intent = new Intent(this, GoodsCommentActivity.class);
//                intent.putExtra(SHOPNUM, mShopNum);
//                startActivity(intent);
//                break;
//            case R.id.title_message_fl:
//                Intent intent1 = new Intent(GoodsDetailsActivity.this, MessageActivity.class);
//                startActivity(intent1);
//                break;
//
//            case R.id.ac_goods_details_coupons_rl:
//                if (couponsInfos == null || couponsInfos.size() == 0) {
//                    Toast.makeText(this, "暂无优惠券信息", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                mGetCouponsAdapter.clear();
//                mGetCouponsAdapter.addList(couponsInfos);
//                mCouponsDialog.show();
//                WindowManager windowManager = getWindowManager();
//                Display display = windowManager.getDefaultDisplay();
//                WindowManager.LayoutParams lp = mCouponsDialog.getWindow().getAttributes();
//                lp.width = (int) (display.getWidth()); //设置宽度
//                lp.gravity = Gravity.BOTTOM;
//                mCouponsDialog.getWindow().setAttributes(lp);
//                break;
//            //商品规格
//            case R.id.ac_goods_details_standard:
//
//                // 显示窗口 设置layout在PopupWindow中显示的位置
//                mPopupWindow.showAtLocation(mGoodsBottom, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
//                break;
//            default:
//                break;
//        }
//    }
//
//    /**
//     * 初始化优惠券dialog
//     */
//    private void initCouponsDialog(List<NewCouponInfo.DataBean.CouponInfo> info) {
//        if (mCouponsDialog != null) {
//            return;
//        }
//        mCouponsDialog = new Dialog(this, R.style.CouponsDialogTheme);
//        mCouponsDialog.setCancelable(true);
//        mCouponsDialog.setCanceledOnTouchOutside(false);
//        View view = LayoutInflater.from(this).inflate(R.layout.layout_selfcollects_dialog, null);
//        dialogCoupons = (RecyclerView) view.findViewById(R.id.dialog_selfconllects_collects);
//        TextView title = (TextView) view.findViewById(R.id.dialog_selfconllects_dialog_title);
//        Button close = (Button) view.findViewById(R.id.coupons_dialog_close_btn);
//        title.setText("可领优惠券");
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        dialogCoupons.setLayoutManager(layoutManager);
//        dialogCoupons.setHasFixedSize(true);
//        dialogCoupons.setItemAnimator(new DefaultItemAnimator());
//        mGetCouponsAdapter = new GetCouponsAdapter(this);
//        close.setOnClickListener(v -> mCouponsDialog.dismiss());
//        mGetCouponsAdapter.setItemClickListener(new OnRecyclerViewItemClickListener<NewCouponInfo.DataBean.CouponInfo>() {
//            @Override
//            public void onItemClick(View view, NewCouponInfo.DataBean.CouponInfo couponsInfo) {
//                getCoupons(couponsInfo.getCC_CODE());
//            }
//        });
//        dialogCoupons.setAdapter(mGetCouponsAdapter);
//        if (info != null)
//            mGetCouponsAdapter.addList(info);
//        mCouponsDialog.setContentView(view);
//    }
//
//    private void getCoupons(String code) {
//        HashMap<String, String> params = new HashMap<String, String>();
//        params.put("code", code);
//        params.put("username", UserBusiness.getLoginName());
//        params.put("userno", UserBusiness.getUserId());
//        params.put("stkC", mShopNum);
//
//        RESTApiImpl.webpromSavecouponcam(params, PBUtil.getPD(this)).subscribe(result -> {
//            if (result.getCode() == NetCodeStatus.OK) {
//                T.ShowShort(result.getMsg());
//                //getProductDetailData();
//                if (result.getData().getCouponInfos() != null) {
//                    couponsInfos.clear();
//                    couponsInfos.addAll(result.getData().getCouponInfos());
//                    mGetCouponsAdapter.addList(couponsInfos);
//                }
//
//            } else {
//                //mGetCouponsAdapter.clear();
//                T.ShowShort(result.getMsg());
//            }
//        }, e -> {
//            L.ii(e.toString());
//        });
//    }
//
//    //获取商家号
//    private String getvendorUserName() {
//        String stk_c = productBean.shopNum;
//        String vendorUserName = null;
//        List<ProductDetailInfo.ProductBean.GoodsUnit> units = productBean.unit;
//        for (ProductDetailInfo.ProductBean.GoodsUnit goodsUnit : units) {
//            if (goodsUnit.stcId.equals(stk_c)) {
//                vendorUserName = goodsUnit.supplier;
//                break;
//            }
//        }
//
//        return vendorUserName;
//    }
//
//    /**
//     * 启动登录界面
//     */
//    public void startLoginActivity() {
//        Intent intent = new Intent();
//        intent.setClass(this, LoginActivity.class);
//        startActivity(intent);
//    }
//
//
//    @Override
//    public void onStandardChange(String standard, String stkc, int count, String price) {
//        mStandard.setText(standard);
//        mShopNum = stkc;
//        mGoodsNum.setText("" + count);
//    }
//
//    @Override
//    public void onStandardWindowClose(String stkc) {
//        getProductDetailData(stkc, item_pk_no, mas_pk_no);
//        getPromotion();
//    }
}
