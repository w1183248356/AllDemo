package wj.com.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wj.com.alldemo.R;


/**
 * @author wangjian
 * @title MainRcleViewAdapter
 * @description
 * @modifier
 * @date
 * @since 2016/4/13 15:44
 **/
public class MainRcleViewAdapter extends RecyclerView.Adapter<MainRcleViewAdapter.ViewHolder> {

    List<String> list;

    public MainRcleViewAdapter(){
        this.list = new ArrayList<>();
    }

    public List<String> getList(){
        return list;
    }

    public void setList(List<String> list){
        this.list = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i, int i1) {
        View view = View.inflate(viewGroup.getContext(), R.layout.item_rcleview, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvMain.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvMain;

        public ViewHolder(View itemView) {
            super(itemView);
            tvMain = (TextView) itemView.findViewById(R.id.tv_main);

        }
    }
}
