package com.mechmocha_chorsipahi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.mechmocha_chorsipahi.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class LeadingBoardAdapter extends Adapter<ViewHolder> {
    private List<LeadingBoard> lbList;

    public class MyViewHolder extends ViewHolder {
        public CircleImageView img;
        public TextView tv_name;
        public TextView tv_position;
        public TextView tv_score;

        public MyViewHolder(View view) {
            super(view);
            this.tv_name = (TextView) view.findViewById(R.id.tv_name);
            this.img = (CircleImageView) view.findViewById(R.id.iv_photo);
            this.tv_score = (TextView) view.findViewById(R.id.tv_score);
            this.tv_position = (TextView) view.findViewById(R.id.tv_position);
        }

        /* access modifiers changed from: 0000 */
        public void bindTo(LeadingBoard leadingBoard, int i) {
            this.tv_name.setText(leadingBoard.getPlayerName());
            this.img.setImageResource(leadingBoard.getImageUrl());
            TextView textView = this.tv_score;
            StringBuilder sb = new StringBuilder();
            String str = "";
            sb.append(str);
            sb.append(leadingBoard.getPoints());
            textView.setText(sb.toString());
            int i2 = i + 1;
            TextView textView2 = this.tv_position;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(i2);
            textView2.setText(sb2.toString());
        }
    }

    public LeadingBoardAdapter(List<LeadingBoard> list) {
        this.lbList = list;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lb_item_list, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        ((MyViewHolder) viewHolder).bindTo((LeadingBoard) this.lbList.get(i), i);
    }

    public int getItemCount() {
        return this.lbList.size();
    }
}
