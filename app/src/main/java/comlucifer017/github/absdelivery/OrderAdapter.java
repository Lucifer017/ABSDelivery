package comlucifer017.github.absdelivery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private Context context;
    private List<Order> listOrder;

    public OrderAdapter(Context context, List<Order> listOrder){
        this.context = context;
        this.listOrder = listOrder;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Order order = listOrder.get(position);
        holder.txtMenu.setText(order.getMenu());
        holder.txtJumlah.setText(order.getJumlah()+" x "+order.getHarga());
        holder.txtPrice.setText("Rp. "+(order.getHarga()*Integer.parseInt(order.getJumlah())));
    }

    @Override
    public int getItemCount() {
        return listOrder.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_menu)
        TextView txtMenu;
        @BindView(R.id.txt_jumlah)
        TextView txtJumlah;
        @BindView(R.id.txt_price)
        TextView txtPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
