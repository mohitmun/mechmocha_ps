package com.mechmocha_chorsipahi.ui.layout;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mechmocha_chorsipahi.R;

public class VideoUserStatusHolder extends RecyclerView.ViewHolder {
    public final RelativeLayout mMaskView;

    public final ImageView mAvatar;
    public final ImageView mIndicator;

    public final LinearLayout mVideoInfo;

    public final TextView mMetaData;

    public  final ImageView role_pic;

    public VideoUserStatusHolder(View v) {
        super(v);

        mMaskView = (RelativeLayout) v.findViewById(R.id.user_control_mask);
        mAvatar = (ImageView) v.findViewById(R.id.default_avatar);
        mIndicator = (ImageView) v.findViewById(R.id.indicator);

        mVideoInfo = (LinearLayout) v.findViewById(R.id.video_info_container);

        mMetaData = (TextView) v.findViewById(R.id.video_info_metadata);
        role_pic = (ImageView) v.findViewById(R.id.role_pic);
    }
}
