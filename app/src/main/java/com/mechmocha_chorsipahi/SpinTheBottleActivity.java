package com.mechmocha_chorsipahi;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.mechmocha_chorsipahi.LeadingBoard;
import com.mechmocha_chorsipahi.LeadingBoardAdapter;
import com.mechmocha_chorsipahi.R;
import com.mechmocha_chorsipahi.SpinTheBottleAppPreferences;
import com.mechmocha_chorsipahi.SpinTheBottleSharedPreference;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class SpinTheBottleActivity extends AppCompatActivity implements OnClickListener, AnimationListener {
    private static final int PICK_FROM_GALLERY = 1;
    private static final int REQUEST_GET_SINGLE_FILE = 1111;
    /* access modifiers changed from: private */
    public static boolean isChittiSelected = false;
    private LinearLayout adView;
    private LinearLayout adViewTopZone;
    private AnimationSet animSet;
    private Builder builderAskForImg;
    private LinearLayout card1;
    private LinearLayout card2;
    private LinearLayout card3;
    private LinearLayout card4;
    private ImageView card_four_img;
    /* access modifiers changed from: private */
    public ImageView card_one_img;
    /* access modifiers changed from: private */
    public ImageView card_three_img;
    /* access modifiers changed from: private */
    public ImageView card_two_img;
    private ImageView center_card_five;
    /* access modifiers changed from: private */
    public ImageView center_card_four;
    /* access modifiers changed from: private */
    public ImageView center_card_one;
    private ImageView center_card_six;
    /* access modifiers changed from: private */
    public ImageView center_card_three;
    /* access modifiers changed from: private */
    public ImageView center_card_two;
    private CircleImageView champ1;
    private CircleImageView champ2;
    private CircleImageView champ3;
    /* access modifiers changed from: private */
    public int[] combo1 = {2, 1, 4, 3};
    /* access modifiers changed from: private */
    public int[] combo2 = {2, 3, 1, 4};
    /* access modifiers changed from: private */
    public int[] combo3 = {1, 4, 2, 3};
    /* access modifiers changed from: private */
    public int[] combo4 = {4, 1, 2, 3};
    /* access modifiers changed from: private */
    public TextView coutdown;
    /* access modifiers changed from: private */
    public AlertDialog dialogAskForImg;
    private Button earn_kisses;
    private List<Integer> femaleIndexes = new ArrayList();
    private ImageView four;
    private TextView four_point;
    private TextView four_text;
    int gameCount = 0;
    /* access modifiers changed from: private */
    public AlertDialog guid1;
    private Builder guid1builder1;
    private Builder guid1builder2;
    /* access modifiers changed from: private */
    public AlertDialog guid2;
    private int img_count = 4;
    private Button invite_friends;
    private TextView kisses_count;
    private LayoutManager layoutManager;
    private List<LeadingBoard> leaderBoardList = new ArrayList();
    /* access modifiers changed from: private */
    public LinearLayout liner1;
    /* access modifiers changed from: private */
    public LinearLayout liner2;
    /* access modifiers changed from: private */
    public LinearLayout liner3;
    /* access modifiers changed from: private */
    public LinearLayout liner4;
    private Adapter mAdapter;
    private List<Integer> maleIndexes = new ArrayList();
    private TypedArray male_player1_images;
    private TypedArray male_player2_images;
    private TypedArray male_player3_images;
    private TypedArray male_player4_images;
    private ImageView one;
    private TextView one_point;
    private TextView one_text;
    private TypedArray player1_images;
    private String[] player1_male_names;
    private String[] player1_names;
    private TypedArray player2_images;
    private String[] player2_male_names;
    private String[] player2_names;
    private TypedArray player3_images;
    private String[] player3_male_names;
    private String[] player3_names;
    private TypedArray player4_images;
    private String[] player4_male_names;
    private String[] player4_names;
    /* access modifiers changed from: private */
    public AlertDialog playerAlert1;
    /* access modifiers changed from: private */
    public AlertDialog playerAlert2;
    /* access modifiers changed from: private */
    public AlertDialog playerAlert3;
    /* access modifiers changed from: private */
    public AlertDialog playerAlert4;
    private Builder playerbuilder1;
    private Builder playerbuilder2;
    private Builder playerbuilder3;
    private Builder playerbuilder4;
    private Button rate_app;
    private RecyclerView recyclerView;
    private SpinTheBottleSharedPreference sharedPreference;
    private ImageView three;
    private TextView three_point;
    private TextView three_text;
    private ImageView two;
    private TextView two_point;
    private TextView two_text;
    private Button upload_my_pic;
    /* access modifiers changed from: private */
    public TextView willTheyKiss;

    public void onAnimationEnd(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.chor_chhiti_home);
        this.gameCount = AppPreferences.getInstance(getApplicationContext()).getLaunchCat10Count();

        this.champ1 = (CircleImageView) findViewById(R.id.iv_champion1);
        this.champ2 = (CircleImageView) findViewById(R.id.iv_champion2);
        this.champ3 = (CircleImageView) findViewById(R.id.iv_champion3);
        this.recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.recyclerView.setHasFixedSize(true);
        this.layoutManager = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.mAdapter = new LeadingBoardAdapter(this.leaderBoardList);
        this.recyclerView.setAdapter(this.mAdapter);
        this.sharedPreference = new SpinTheBottleSharedPreference();
        this.sharedPreference.removeAllFavorite(getApplicationContext());
        AppPreferences.getInstance(getApplicationContext()).setImageUrl("");
        SpinTheBottleAppPreferences.getInstance(getApplicationContext()).setPlayer3KISSToZero();
        SpinTheBottleAppPreferences.getInstance(getApplicationContext()).setPlayer5KISSToZero();
        SpinTheBottleAppPreferences.getInstance(getApplicationContext()).setPlayer6KISSToZero();
        SpinTheBottleAppPreferences.getInstance(getApplicationContext()).setPlayer7KISSToZero();
        SpinTheBottleAppPreferences.getInstance(getApplicationContext()).setPlayer8KISSToZero();
        SpinTheBottleAppPreferences.getInstance(getApplicationContext()).setPlayer9KISSToZero();
        SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementPlayer1ChangeCount();
        SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementPlayer2ChangeCount();
        SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementPlayer3ChangeCount();
        SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementPlayer4ChangeCount();
        configuration();
        for (int i = 0; i < 4; i++) {
            initPlayers(i);
        }
        if (AppPreferences.getInstance(this).getLaunchCat5Count() == 0) {
            showguid();
        }
    }

    public void showguid() {
        this.guid1builder2 = new Builder(this);
        this.guid1builder2.setPositiveButton((CharSequence) "Ok", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                SpinTheBottleActivity.this.guid2.dismiss();
            }
        });
        this.guid1builder2.setView(getLayoutInflater().inflate(R.layout.guid2, null));
        this.guid2 = this.guid1builder2.create();
        this.guid1builder1 = new Builder(this);
        this.guid1builder1.setPositiveButton((CharSequence) "Next Step", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                SpinTheBottleActivity.this.guid1.dismiss();
                SpinTheBottleActivity.this.guid2.show();
            }
        });
        this.guid1builder1.setView(getLayoutInflater().inflate(R.layout.guid, null));
        this.guid1 = this.guid1builder1.create();
        this.guid1.show();
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r16) {

            SpinTheBottleActivity r15 = this;
            SpinTheBottleActivity r8 = r15;
            AppPreferences r1 = AppPreferences.getInstance(r15);
            r1.incrementCat5Count();
//            int r1 = r16.getId();
            int r2 = r8.gameCount;
            int r3 = r2 % 4;
            int r4 = 4;
            int r5 = 2;
            int r6 = 3;
            int r7 = 1;
            int r9 = 0;
//            if (r3 != 0) goto L_0x0027
//            int[] r2 = r8.combo1;
//            r3 = r2[r9];
//            r4 = r2[r7];
//            r10 = r2[r5];
//            r2 = r2[r6];
//        L_0x0023:
//            r14 = r10
//            r10 = r3
//            r3 = r14
//            goto L_0x0057
//        L_0x0027:
//            int r3 = r2 % 4
//            if (r3 != r7) goto L_0x0036
//            int[] r2 = r8.combo2
//            r3 = r2[r9]
//            r4 = r2[r7]
//            r10 = r2[r5]
//            r2 = r2[r6]
//            goto L_0x0023
//        L_0x0036:
//            int r3 = r2 % 4
//            if (r3 != r5) goto L_0x0045
//            int[] r2 = r8.combo3
//            r3 = r2[r9]
//            r4 = r2[r7]
//            r10 = r2[r5]
//            r2 = r2[r6]
//            goto L_0x0023
//        L_0x0045:
//            int r2 = r2 % r4
//            if (r2 != r6) goto L_0x0053
//            int[] r2 = r8.combo4
//            r3 = r2[r9]
//            r4 = r2[r7]
//            r10 = r2[r5]
//            r2 = r2[r6]
//            goto L_0x0023
//        L_0x0053:
//            r2 = 4
//            r3 = 3
//            r4 = 2
//            r10 = 1
//        L_0x0057:
//            r11 = 2131296327(0x7f090047, float:1.8210568E38)
//            if (r1 != r11) goto L_0x0081
//            boolean r12 = isChittiSelected
//            if (r12 == 0) goto L_0x0081
//            if (r2 != r6) goto L_0x0081
//            r15.chorsipahi(r10, r4, r3, r2)
//            if (r10 == r5) goto L_0x006c
//            if (r4 != r5) goto L_0x006a
//            goto L_0x006c
//        L_0x006a:
//            r6 = 1
//            goto L_0x006d
//        L_0x006c:
//            r6 = 0
//        L_0x006d:
//            r15.pointDistributionAndRightWrong(r6, r10, r4, r3)
//            mantri.raja.rajamantri.SpinTheBottleActivity$4 r9 = new mantri.raja.rajamantri.SpinTheBottleActivity$4
//            r2 = 3000(0xbb8, double:1.482E-320)
//            r4 = 1000(0x3e8, double:4.94E-321)
//            r0 = r9
//            r1 = r15
//            r7 = r10
//            r0.<init>(r2, r4, r6, r7)
//            r9.start()
//            goto L_0x02d6
//        L_0x0081:
//            r12 = 2131296324(0x7f090044, float:1.8210561E38)
//            if (r1 != r12) goto L_0x00aa
//            boolean r13 = isChittiSelected
//            if (r13 == 0) goto L_0x00aa
//            if (r2 != r6) goto L_0x00aa
//            r15.chorsipahi(r10, r4, r3, r2)
//            if (r3 == r5) goto L_0x0096
//            if (r2 != r5) goto L_0x0094
//            goto L_0x0096
//        L_0x0094:
//            r6 = 1
//            goto L_0x0097
//        L_0x0096:
//            r6 = 0
//        L_0x0097:
//            r15.pointDistributionAndRightWrong(r6, r10, r4, r3)
//            mantri.raja.rajamantri.SpinTheBottleActivity$5 r7 = new mantri.raja.rajamantri.SpinTheBottleActivity$5
//            r2 = 3000(0xbb8, double:1.482E-320)
//            r4 = 1000(0x3e8, double:4.94E-321)
//            r0 = r7
//            r1 = r15
//            r0.<init>(r2, r4, r6)
//            r7.start()
//            goto L_0x02d6
//        L_0x00aa:
//            r2 = 2131296328(0x7f090048, float:1.821057E38)
//            r3 = 2131296325(0x7f090045, float:1.8210563E38)
//            if (r1 == r3) goto L_0x00b8
//            if (r1 == r2) goto L_0x00b8
//            if (r1 == r11) goto L_0x00b8
//            if (r1 != r12) goto L_0x01ad
//
//        L_0x00e6:
//            r0 = 2131230825(0x7f080069, float:1.8077714E38)
//            if (r1 != r3) goto L_0x011a
//            boolean r3 = isChittiSelected
//            if (r3 != 0) goto L_0x011a
//            isChittiSelected = r7
//            android.content.Context r1 = r15.getApplicationContext()
//            com.bumptech.glide.RequestManager r1 = com.bumptech.glide.Glide.with(r1)
//            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
//            com.bumptech.glide.DrawableTypeRequest r0 = r1.load(r0)
//            android.widget.ImageView r1 = r8.center_card_one
//            r0.into(r1)
//            android.widget.ImageView r0 = r8.center_card_two
//            r0.setVisibility(r9)
//            android.widget.ImageView r0 = r8.center_card_three
//            r0.setVisibility(r9)
//            android.widget.ImageView r0 = r8.center_card_four
//            r0.setVisibility(r9)
//            r15.callShowChttiLogic()
//            goto L_0x02d6
//        L_0x011a:
//            if (r1 != r2) goto L_0x014b
//            boolean r2 = isChittiSelected
//            if (r2 != 0) goto L_0x014b
//            isChittiSelected = r7
//            android.widget.ImageView r1 = r8.center_card_one
//            r1.setVisibility(r9)
//            android.content.Context r1 = r15.getApplicationContext()
//            com.bumptech.glide.RequestManager r1 = com.bumptech.glide.Glide.with(r1)
//            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
//            com.bumptech.glide.DrawableTypeRequest r0 = r1.load(r0)
//            android.widget.ImageView r1 = r8.center_card_two
//            r0.into(r1)
//            android.widget.ImageView r0 = r8.center_card_three
//            r0.setVisibility(r9)
//            android.widget.ImageView r0 = r8.center_card_four
//            r0.setVisibility(r9)
//            r15.callShowChttiLogic()
//            goto L_0x02d6
//        L_0x014b:
//            if (r1 != r11) goto L_0x017c
//            boolean r2 = isChittiSelected
//            if (r2 != 0) goto L_0x017c
//            isChittiSelected = r7
//            android.widget.ImageView r1 = r8.center_card_one
//            r1.setVisibility(r9)
//            android.widget.ImageView r1 = r8.center_card_two
//            r1.setVisibility(r9)
//            android.widget.ImageView r1 = r8.center_card_four
//            r1.setVisibility(r9)
//            android.content.Context r1 = r15.getApplicationContext()
//            com.bumptech.glide.RequestManager r1 = com.bumptech.glide.Glide.with(r1)
//            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
//            com.bumptech.glide.DrawableTypeRequest r0 = r1.load(r0)
//            android.widget.ImageView r1 = r8.center_card_three
//            r0.into(r1)
//            r15.callShowChttiLogic()
//            goto L_0x02d6
//        L_0x017c:
//            if (r1 != r12) goto L_0x02d6
//            boolean r1 = isChittiSelected;
//            if (r1 != 0) goto L_0x02d6
//            isChittiSelected = r7;
            ImageView rr1 = r8.center_card_one;
            rr1.setVisibility(r9);
             rr1 = r8.center_card_two;
            rr1.setVisibility(r9);
            rr1 = r8.center_card_three;
            rr1.setVisibility(r9);
            android.content.Context context = r15.getApplicationContext();
            com.bumptech.glide.RequestManager rm = com.bumptech.glide.Glide.with(rr1);
//            RequestManager rr01 = rm.load(rr0);
//            android.widget.ImageView rrr1 = r8.center_card_four;
//            rr01.into(r1);
            r15.callShowChttiLogic();
//            goto L_0x02d6
//        throw new UnsupportedOperationException("Method not decompiled: mantri.raja.rajamantri.SpinTheBottleActivity.onClick(android.view.View):void");
//    */

    }

    public void callShowChttiLogic() {
        this.card_four_img.setVisibility(View.VISIBLE);
        CountDownTimer r2 = new CountDownTimer(1000, 500) {
            public void onTick(long j) {
                TextView access$200 = SpinTheBottleActivity.this.coutdown;
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(j / 1000);
                access$200.setText(sb.toString());
            }

            public void onFinish() {
                SpinTheBottleActivity.this.center_card_one.setVisibility(View.GONE);
                SpinTheBottleActivity.this.center_card_two.setVisibility(View.GONE);
                SpinTheBottleActivity.this.center_card_three.setVisibility(View.GONE);
                SpinTheBottleActivity.this.center_card_four.setVisibility(View.GONE);
                SpinTheBottleActivity.this.card_one_img.setVisibility(View.VISIBLE);
                SpinTheBottleActivity.this.card_two_img.setVisibility(View.VISIBLE);
                SpinTheBottleActivity.this.card_three_img.setVisibility(View.VISIBLE);
                if (SpinTheBottleActivity.this.gameCount % 4 == 0) {
                    SpinTheBottleActivity spinTheBottleActivity = SpinTheBottleActivity.this;
                    spinTheBottleActivity.showChhti(spinTheBottleActivity.combo1[0], SpinTheBottleActivity.this.combo1[1], SpinTheBottleActivity.this.combo1[2], SpinTheBottleActivity.this.combo1[3]);
                } else if (SpinTheBottleActivity.this.gameCount % 4 == 1) {
                    SpinTheBottleActivity spinTheBottleActivity2 = SpinTheBottleActivity.this;
                    spinTheBottleActivity2.showChhti(spinTheBottleActivity2.combo2[0], SpinTheBottleActivity.this.combo2[1], SpinTheBottleActivity.this.combo2[2], SpinTheBottleActivity.this.combo2[3]);
                } else if (SpinTheBottleActivity.this.gameCount % 4 == 2) {
                    SpinTheBottleActivity spinTheBottleActivity3 = SpinTheBottleActivity.this;
                    spinTheBottleActivity3.showChhti(spinTheBottleActivity3.combo3[0], SpinTheBottleActivity.this.combo3[1], SpinTheBottleActivity.this.combo3[2], SpinTheBottleActivity.this.combo3[3]);
                } else if (SpinTheBottleActivity.this.gameCount % 4 == 3) {
                    SpinTheBottleActivity spinTheBottleActivity4 = SpinTheBottleActivity.this;
                    spinTheBottleActivity4.showChhti(spinTheBottleActivity4.combo4[0], SpinTheBottleActivity.this.combo4[1], SpinTheBottleActivity.this.combo4[2], SpinTheBottleActivity.this.combo4[3]);
                }
                SpinTheBottleActivity.this.willTheyKiss.setText("चोर सिपाही का पता लगाए?");
            }
        };
        r2.start();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.earn_kisses.setEnabled(true);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.earn_kisses.setEnabled(true);
    }

    public void configuration() {
        Integer valueOf = Integer.valueOf(0);
        isChittiSelected = false;
        this.builderAskForImg = new Builder(this);
        this.builderAskForImg.setPositiveButton((CharSequence) "Upload My Picture", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                SpinTheBottleActivity.this.dialogAskForImg.dismiss();
                String str = "android.permission.READ_EXTERNAL_STORAGE";
                if (ActivityCompat.checkSelfPermission(SpinTheBottleActivity.this, str) != 0) {
                    ActivityCompat.requestPermissions(SpinTheBottleActivity.this, new String[]{str, "android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
                    return;
                }
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("image/*");
                SpinTheBottleActivity.this.startActivityForResult(Intent.createChooser(intent, "Select Picture"), SpinTheBottleActivity.REQUEST_GET_SINGLE_FILE);
            }
        });
        this.builderAskForImg.setNegativeButton((CharSequence) "No Thanks", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                SpinTheBottleActivity.this.dialogAskForImg.dismiss();
            }
        });
        this.builderAskForImg.setView(getLayoutInflater().inflate(R.layout.change_picture, null));
        this.dialogAskForImg = this.builderAskForImg.setTitle((CharSequence) "Upload Your Profile Picture..").create();
        this.upload_my_pic = (Button) findViewById(R.id.upload_my_pic);
        this.upload_my_pic.setOnClickListener(this);
        this.upload_my_pic.setEnabled(true);
        this.earn_kisses = (Button) findViewById(R.id.earn_kisses);
        this.earn_kisses.setOnClickListener(this);
        this.earn_kisses.setEnabled(true);
        this.invite_friends = (Button) findViewById(R.id.invite_friends);
        this.invite_friends.setOnClickListener(this);
        this.rate_app = (Button) findViewById(R.id.rate_app);
        this.rate_app.setOnClickListener(this);
        this.liner1 = (LinearLayout) findViewById(R.id.liner_one);
        this.liner2 = (LinearLayout) findViewById(R.id.liner_two);
        this.liner3 = (LinearLayout) findViewById(R.id.liner_three);
        this.liner4 = (LinearLayout) findViewById(R.id.liner_four);
        this.card1 = (LinearLayout) findViewById(R.id.card_one);
        this.card2 = (LinearLayout) findViewById(R.id.card_two);
        this.card3 = (LinearLayout) findViewById(R.id.card_three);
        this.card4 = (LinearLayout) findViewById(R.id.card_four);
        this.center_card_one = (ImageView) findViewById(R.id.center_card_one);
        this.center_card_two = (ImageView) findViewById(R.id.center_card_two);
        this.center_card_three = (ImageView) findViewById(R.id.center_card_three);
        this.center_card_four = (ImageView) findViewById(R.id.center_card_four);
        this.center_card_five = (ImageView) findViewById(R.id.center_card_five);
        this.center_card_six = (ImageView) findViewById(R.id.center_card_six);
        this.center_card_five.setVisibility(View.GONE);
        this.center_card_six.setVisibility(View.GONE);
        this.one = (ImageView) findViewById(R.id.one);
        this.two = (ImageView) findViewById(R.id.two);
        this.three = (ImageView) findViewById(R.id.three);
        this.four = (ImageView) findViewById(R.id.four);
        this.card_one_img = (ImageView) findViewById(R.id.card_one_img);
        this.card_two_img = (ImageView) findViewById(R.id.card_two_img);
        this.card_three_img = (ImageView) findViewById(R.id.card_three_img);
        this.card_four_img = (ImageView) findViewById(R.id.card_four_img);
        this.one_text = (TextView) findViewById(R.id.one_text);
        this.two_text = (TextView) findViewById(R.id.two_text);
        this.three_text = (TextView) findViewById(R.id.three_text);
        this.four_text = (TextView) findViewById(R.id.four_text);
        this.one_point = (TextView) findViewById(R.id.one_points);
        this.two_point = (TextView) findViewById(R.id.two_points);
        this.three_point = (TextView) findViewById(R.id.three_points);
        this.four_point = (TextView) findViewById(R.id.four_points);
        this.one.setVisibility(View.VISIBLE);
        this.two.setVisibility(View.VISIBLE);
        this.three.setVisibility(View.VISIBLE);
        this.four.setVisibility(View.VISIBLE);
        this.one_text.setVisibility(View.VISIBLE);
        this.two_text.setVisibility(View.VISIBLE);
        this.three_text.setVisibility(View.VISIBLE);
        this.four_text.setVisibility(View.VISIBLE);
        this.player1_images = getResources().obtainTypedArray(R.array.player1_images);
        this.player2_images = getResources().obtainTypedArray(R.array.player2_images);
        this.player3_images = getResources().obtainTypedArray(R.array.player3_images);
        this.player4_images = getResources().obtainTypedArray(R.array.player4_images);
        this.male_player1_images = getResources().obtainTypedArray(R.array.male_player1_images);
        this.male_player2_images = getResources().obtainTypedArray(R.array.male_player2_images);
        this.male_player3_images = getResources().obtainTypedArray(R.array.male_player3_images);
        this.male_player4_images = getResources().obtainTypedArray(R.array.male_player4_images);
        this.coutdown = (TextView) findViewById(R.id.countdown);
        this.kisses_count = (TextView) findViewById(R.id.kisses_count);
        this.player1_names = getResources().getStringArray(R.array.player1_names);
        this.player2_names = getResources().getStringArray(R.array.player2_names);
        this.player3_names = getResources().getStringArray(R.array.player3_names);
        this.player4_names = getResources().getStringArray(R.array.player4_names);
        this.player1_male_names = getResources().getStringArray(R.array.player1_male_names);
        this.player2_male_names = getResources().getStringArray(R.array.player2_male_names);
        this.player3_male_names = getResources().getStringArray(R.array.player3_male_names);
        this.player4_male_names = getResources().getStringArray(R.array.player4_male_names);
        this.willTheyKiss = (TextView) findViewById(R.id.willtheykiss);
        this.sharedPreference.saveFavorites(getApplicationContext(), this.maleIndexes);
        PrepareLeaderBoard();
        this.willTheyKiss.setBackgroundColor(SupportMenu.CATEGORY_MASK);
        whoseTurn();
        AppPreferences.getInstance(getApplicationContext()).incrementCat10Count();
        this.center_card_one.setOnClickListener(this);
        this.center_card_two.setOnClickListener(this);
        this.center_card_three.setOnClickListener(this);
        this.center_card_four.setOnClickListener(this);
        Glide.with(getApplicationContext()).load(valueOf).into(this.center_card_one);
        Glide.with(getApplicationContext()).load(valueOf).into(this.center_card_two);
        Glide.with(getApplicationContext()).load(valueOf).into(this.center_card_three);
        Glide.with(getApplicationContext()).load(valueOf).into(this.center_card_four);
        RequestManager with = Glide.with(getApplicationContext());
        Integer valueOf2 = Integer.valueOf(R.drawable.envolop);
        with.load(valueOf2).into(this.center_card_one);
        Glide.with(getApplicationContext()).load(valueOf2).into(this.center_card_two);
        Glide.with(getApplicationContext()).load(valueOf2).into(this.center_card_three);
        Glide.with(getApplicationContext()).load(valueOf2).into(this.center_card_four);
        this.center_card_one.setVisibility(View.VISIBLE);
        this.center_card_two.setVisibility(View.VISIBLE);
        this.center_card_three.setVisibility(View.VISIBLE);
        this.center_card_four.setVisibility(View.VISIBLE);
        String str = "0 PTS";
        this.one_point.setText(str);
        this.two_point.setText(str);
        this.three_point.setText(str);
        this.four_point.setText(str);
        this.willTheyKiss.setText("निचे से एक चिट्टी चुने !");
        this.card_one_img.setVisibility(View.GONE);
        this.card_two_img.setVisibility(View.GONE);
        this.card_three_img.setVisibility(View.GONE);
        this.card_four_img.setVisibility(View.GONE);
        this.card1.setBackgroundColor(0);
        this.card2.setBackgroundColor(0);
        this.card3.setBackgroundColor(0);
        this.card4.setBackgroundColor(0);
        this.willTheyKiss.setVisibility(View.VISIBLE);
        this.coutdown.setVisibility(View.VISIBLE);
    }

    private void rotate() {
        this.animSet = new AnimationSet(true);
        this.animSet.setInterpolator(new DecelerateInterpolator());
        this.animSet.setFillAfter(true);
        this.animSet.setFillEnabled(true);
        RotateAnimation rotateAnimation = new RotateAnimation(-0.0f, -360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setAnimationListener(this);
        rotateAnimation.setDuration(50);
        rotateAnimation.setRepeatCount(50);
        rotateAnimation.setFillAfter(true);
        this.animSet.addAnimation(rotateAnimation);
    }

    public int randomlyMaleFemaleSelection(int i) {
        if (new Random().nextInt(2) == 0) {
            this.maleIndexes.add(Integer.valueOf(i));
            return 0;
        }
        this.femaleIndexes.add(Integer.valueOf(i));
        return 1;
    }

    public void initPlayers(int i) {
        String str = "Next Game";
        if (i == 0) {
            int randomlyMaleFemaleSelection = randomlyMaleFemaleSelection(i);
            int player1ChangeCount = SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getPlayer1ChangeCount() % this.img_count;
            this.playerbuilder1 = new Builder(this);
            this.playerbuilder1.setPositiveButton((CharSequence) str, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    SpinTheBottleActivity.this.playerAlert1.dismiss();
                    if (VERSION.SDK_INT >= 11) {
                        SpinTheBottleActivity.this.recreate();
                        return;
                    }
                    Intent intent = SpinTheBottleActivity.this.getIntent();
                    intent.addFlags(65536);
                    SpinTheBottleActivity.this.finish();
                    SpinTheBottleActivity.this.overridePendingTransition(0, 0);
                    SpinTheBottleActivity.this.startActivity(intent);
                    SpinTheBottleActivity.this.overridePendingTransition(0, 0);
                }
            });
            View inflate = getLayoutInflater().inflate(R.layout.winner_popup, null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.winner);
            if (randomlyMaleFemaleSelection != 0) {
                Glide.with(getApplicationContext()).load(Integer.valueOf(this.player1_images.getResourceId(player1ChangeCount, 0))).into(this.one);
                this.one_text.setText(this.player1_names[player1ChangeCount]);
                imageView.setImageResource(this.player1_images.getResourceId(player1ChangeCount, 0));
            } else {
                Glide.with(getApplicationContext()).load(Integer.valueOf(this.male_player1_images.getResourceId(player1ChangeCount, 0))).into(this.one);
                this.one_text.setText(this.player1_male_names[player1ChangeCount]);
                imageView.setImageResource(this.male_player1_images.getResourceId(player1ChangeCount, 0));
            }
            this.playerbuilder1.setView(inflate);
            this.playerAlert1 = this.playerbuilder1.create();
        } else if (i == 1) {
            int randomlyMaleFemaleSelection2 = randomlyMaleFemaleSelection(i);
            this.playerbuilder2 = new Builder(this);
            this.playerbuilder2.setPositiveButton((CharSequence) str, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    SpinTheBottleActivity.this.playerAlert2.dismiss();
                    if (VERSION.SDK_INT >= 11) {
                        SpinTheBottleActivity.this.recreate();
                        return;
                    }
                    Intent intent = SpinTheBottleActivity.this.getIntent();
                    intent.addFlags(65536);
                    SpinTheBottleActivity.this.finish();
                    SpinTheBottleActivity.this.overridePendingTransition(0, 0);
                    SpinTheBottleActivity.this.startActivity(intent);
                    SpinTheBottleActivity.this.overridePendingTransition(0, 0);
                }
            });
            View inflate2 = getLayoutInflater().inflate(R.layout.winner_popup, null);
            ImageView imageView2 = (ImageView) inflate2.findViewById(R.id.winner);
            int player2ChangeCount = SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getPlayer2ChangeCount() % this.img_count;
            if (randomlyMaleFemaleSelection2 != 0) {
                Glide.with(getApplicationContext()).load(Integer.valueOf(this.player2_images.getResourceId(player2ChangeCount, 0))).into(this.two);
                this.two_text.setText(this.player2_names[player2ChangeCount]);
                imageView2.setImageResource(this.player2_images.getResourceId(player2ChangeCount, 0));
            } else {
                Glide.with(getApplicationContext()).load(Integer.valueOf(this.male_player2_images.getResourceId(player2ChangeCount, 0))).into(this.two);
                this.two_text.setText(this.player2_male_names[player2ChangeCount]);
                imageView2.setImageResource(this.male_player2_images.getResourceId(player2ChangeCount, 0));
            }
            this.playerbuilder2.setView(inflate2);
            this.playerAlert2 = this.playerbuilder2.create();
        } else if (i == 2) {
            this.femaleIndexes.add(Integer.valueOf(2));
            this.playerbuilder3 = new Builder(this);
            this.playerbuilder3.setPositiveButton((CharSequence) str, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    SpinTheBottleActivity.this.playerAlert3.dismiss();
                    if (VERSION.SDK_INT >= 11) {
                        SpinTheBottleActivity.this.recreate();
                        return;
                    }
                    Intent intent = SpinTheBottleActivity.this.getIntent();
                    intent.addFlags(65536);
                    SpinTheBottleActivity.this.finish();
                    SpinTheBottleActivity.this.overridePendingTransition(0, 0);
                    SpinTheBottleActivity.this.startActivity(intent);
                    SpinTheBottleActivity.this.overridePendingTransition(0, 0);
                }
            });
            View inflate3 = getLayoutInflater().inflate(R.layout.winner_popup, null);
            ImageView imageView3 = (ImageView) inflate3.findViewById(R.id.winner);
            int player3ChangeCount = SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getPlayer3ChangeCount() % this.img_count;
            Glide.with(getApplicationContext()).load(Integer.valueOf(this.player3_images.getResourceId(player3ChangeCount, 0))).into(this.three);
            this.three_text.setText(this.player3_names[player3ChangeCount]);
            imageView3.setImageResource(this.player3_images.getResourceId(player3ChangeCount, 0));
            this.playerbuilder3.setView(inflate3);
            this.playerAlert3 = this.playerbuilder3.create();
        } else if (i == 3) {
            this.playerbuilder4 = new Builder(this);
            this.playerbuilder4.setPositiveButton((CharSequence) str, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    SpinTheBottleActivity.this.playerAlert4.dismiss();
                    if (VERSION.SDK_INT >= 11) {
                        SpinTheBottleActivity.this.recreate();
                        return;
                    }
                    Intent intent = SpinTheBottleActivity.this.getIntent();
                    intent.addFlags(65536);
                    SpinTheBottleActivity.this.finish();
                    SpinTheBottleActivity.this.overridePendingTransition(0, 0);
                    SpinTheBottleActivity.this.startActivity(intent);
                    SpinTheBottleActivity.this.overridePendingTransition(0, 0);
                }
            });
            View inflate4 = getLayoutInflater().inflate(R.layout.you_winner_popup, null);
            ImageView imageView4 = (ImageView) inflate4.findViewById(R.id.winner);
            Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.default_avata)).into(this.four);
            this.four_text.setText("You");
            imageView4.setImageURI(Uri.parse(SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getImgUrl()));
            this.playerbuilder4.setView(inflate4);
            this.playerAlert4 = this.playerbuilder4.create();
        }
    }

    public void whoseTurn() {
        SpinTheBottleAppPreferences.getInstance(getApplicationContext()).increasePlayerTurn();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == REQUEST_GET_SINGLE_FILE) {
            try {
                Uri data = intent.getData();
                String pathFromURI = getPathFromURI(data);
                if (pathFromURI != null) {
                    data = Uri.fromFile(new File(pathFromURI));
                }
                AppPreferences.getInstance(this).setImageUrl(data.toString());
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).setImgUrl(data.toString());
                this.four.setImageURI(Uri.parse(SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getImgUrl()));
                this.upload_my_pic.setEnabled(true);
            } catch (Exception unused) {
            }
        }
    }

    public String getPathFromURI(Uri uri) {
        String str = "_data";
        Cursor query = getContentResolver().query(uri, new String[]{str}, null, null, null);
        String string = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow(str)) : null;
        query.close();
        return string;
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1 && iArr.length > 0 && iArr[0] == 0) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_GET_SINGLE_FILE);
        }
    }

    public void PrepareLeaderBoard() {
        LeadingBoard leadingBoard;
        LeadingBoard leadingBoard2;
        LeadingBoard leadingBoard3;
        this.leaderBoardList.clear();
        int player1ChangeCount = SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getPlayer1ChangeCount() % this.img_count;
        int kiss1Count = SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getKiss1Count();
        if (this.maleIndexes.contains(Integer.valueOf(0))) {
            leadingBoard = new LeadingBoard(this.male_player1_images.getResourceId(player1ChangeCount, 0), this.player1_male_names[player1ChangeCount], kiss1Count, 4);
        } else {
            leadingBoard = new LeadingBoard(this.player1_images.getResourceId(player1ChangeCount, 0), this.player1_names[player1ChangeCount], kiss1Count, 4);
        }
        int player2ChangeCount = SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getPlayer2ChangeCount() % this.img_count;
        int kiss2Count = SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getKiss2Count();
        if (this.maleIndexes.contains(Integer.valueOf(1))) {
            leadingBoard2 = new LeadingBoard(this.male_player2_images.getResourceId(player2ChangeCount, 0), this.player2_male_names[player2ChangeCount], kiss2Count, 4);
        } else {
            leadingBoard2 = new LeadingBoard(this.player2_images.getResourceId(player2ChangeCount, 0), this.player2_names[player2ChangeCount], kiss2Count, 4);
        }
        int player2ChangeCount2 = SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getPlayer2ChangeCount() % this.img_count;
        int kiss3Count = SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getKiss3Count();
        if (this.maleIndexes.contains(Integer.valueOf(2))) {
            leadingBoard3 = new LeadingBoard(this.male_player3_images.getResourceId(player2ChangeCount2, 0), this.player3_male_names[player2ChangeCount2], kiss3Count, 4);
        } else {
            leadingBoard3 = new LeadingBoard(this.player3_images.getResourceId(player2ChangeCount2, 0), this.player3_names[player2ChangeCount2], kiss3Count, 4);
        }
        String str = "You";
        LeadingBoard leadingBoard4 = new LeadingBoard(R.drawable.default_avata, str, SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getKiss4Count(), 4);
        this.leaderBoardList.add(leadingBoard);
        this.leaderBoardList.add(leadingBoard2);
        this.leaderBoardList.add(leadingBoard3);
        this.leaderBoardList.add(leadingBoard4);
        Collections.sort(this.leaderBoardList, new Comparator<LeadingBoard>() {
            public int compare(LeadingBoard leadingBoard, LeadingBoard leadingBoard2) {
                if (leadingBoard.getPoints() < leadingBoard2.getPoints()) {
                    return 1;
                }
                return leadingBoard.getPoints() > leadingBoard2.getPoints() ? -1 : 0;
            }
        });
        if (!((LeadingBoard) this.leaderBoardList.get(0)).getPlayerName().equals(str)) {
            Glide.with(getApplicationContext()).load(Integer.valueOf(((LeadingBoard) this.leaderBoardList.get(0)).getImageUrl())).into(this.champ1);
        } else if (SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getImgUrl().length() > 2) {
            this.champ1.setImageURI(Uri.parse(SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getImgUrl()));
        } else {
            Glide.with(getApplicationContext()).load(Integer.valueOf(((LeadingBoard) this.leaderBoardList.get(0)).getImageUrl())).into(this.champ1);
        }
        if (!((LeadingBoard) this.leaderBoardList.get(1)).getPlayerName().equals(str)) {
            Glide.with(getApplicationContext()).load(Integer.valueOf(((LeadingBoard) this.leaderBoardList.get(1)).getImageUrl())).into(this.champ2);
        } else if (SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getImgUrl().length() > 2) {
            this.champ2.setImageURI(Uri.parse(SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getImgUrl()));
        } else {
            Glide.with(getApplicationContext()).load(Integer.valueOf(((LeadingBoard) this.leaderBoardList.get(1)).getImageUrl())).into(this.champ2);
        }
        if (!((LeadingBoard) this.leaderBoardList.get(2)).getPlayerName().equals(str)) {
            Glide.with(getApplicationContext()).load(Integer.valueOf(((LeadingBoard) this.leaderBoardList.get(2)).getImageUrl())).into(this.champ3);
        } else if (SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getImgUrl().length() > 2) {
            this.champ3.setImageURI(Uri.parse(SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getImgUrl()));
        } else {
            Glide.with(getApplicationContext()).load(Integer.valueOf(((LeadingBoard) this.leaderBoardList.get(2)).getImageUrl())).into(this.champ3);
        }
        this.mAdapter.notifyDataSetChanged();
    }

    public void showChhti(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        this.center_card_five.setVisibility(View.VISIBLE);
        this.center_card_six.setVisibility(View.VISIBLE);
        if (i5 == 2 || i5 == 4) {
            int player1ChangeCount = SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getPlayer1ChangeCount() % this.img_count;
            if (this.maleIndexes.contains(Integer.valueOf(0))) {
                Glide.with(getApplicationContext()).load(Integer.valueOf(this.male_player1_images.getResourceId(player1ChangeCount, 0))).into(this.center_card_five);
            } else {
                Glide.with(getApplicationContext()).load(Integer.valueOf(this.player1_images.getResourceId(player1ChangeCount, 0))).into(this.center_card_five);
            }
        }
        if (i6 == 2 || i6 == 4) {
            int player2ChangeCount = SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getPlayer2ChangeCount() % this.img_count;
            if (this.maleIndexes.contains(Integer.valueOf(1))) {
                Glide.with(getApplicationContext()).load(Integer.valueOf(this.male_player2_images.getResourceId(player2ChangeCount, 0))).into(this.center_card_five);
            } else {
                Glide.with(getApplicationContext()).load(Integer.valueOf(this.player2_images.getResourceId(player2ChangeCount, 0))).into(this.center_card_five);
            }
        }
        if (i7 == 2 || i7 == 4) {
            int player3ChangeCount = SpinTheBottleAppPreferences.getInstance(getApplicationContext()).getPlayer3ChangeCount() % this.img_count;
            if (this.maleIndexes.contains(Integer.valueOf(2))) {
                Glide.with(getApplicationContext()).load(Integer.valueOf(this.male_player3_images.getResourceId(player3ChangeCount, 0))).into(this.center_card_six);
            } else {
                Glide.with(getApplicationContext()).load(Integer.valueOf(this.player3_images.getResourceId(player3ChangeCount, 0))).into(this.center_card_six);
            }
        }
        if (i8 == 2 || i8 == 4) {
            Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.default_avata)).into(this.center_card_six);
        }
        String str = "1000 PTS";
        String str2 = "0 PTS";
        if (i5 == 1) {
            Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.king)).into(this.card_one_img);
            this.one_point.setText(str);
            SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss1Count(1000);
        } else if (i5 == 2) {
            this.one_point.setText(str2);
        } else if (i5 == 3) {
            Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.mantri)).into(this.card_one_img);
            this.one_point.setText(str2);
        } else if (i5 == 4) {
            this.one_point.setText(str2);
        }
        if (i6 == 1) {
            Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.king)).into(this.card_two_img);
            this.two_point.setText(str);
            SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss2Count(1000);
        } else if (i6 == 2) {
            this.two_point.setText(str2);
        } else if (i6 == 3) {
            Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.mantri)).into(this.card_two_img);
            this.two_point.setText(str2);
        } else if (i6 == 4) {
            this.two_point.setText(str2);
        }
        if (i7 == 1) {
            Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.king)).into(this.card_three_img);
            this.three_point.setText(str);
            SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss3Count(1000);
        } else if (i7 == 2) {
            this.three_point.setText(str2);
        } else if (i7 == 3) {
            Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.mantri)).into(this.card_three_img);
            this.three_point.setText(str2);
        } else if (i7 == 4) {
            this.three_point.setText(str2);
        }
        if (i8 == 1) {
            Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.king)).into(this.card_four_img);
            this.four_point.setText(str);
            SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss4Count(1000);
        } else if (i8 == 2) {
            this.four_point.setText(str2);
        } else if (i8 == 3) {
            Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.mantri)).into(this.card_four_img);
            this.four_point.setText(str2);
        } else if (i8 == 4) {
            this.four_point.setText(str2);
        }
        this.center_card_one.setVisibility(View.VISIBLE);
        this.center_card_two.setVisibility(View.VISIBLE);
        this.center_card_three.setVisibility(View.VISIBLE);
        this.center_card_four.setVisibility(View.VISIBLE);
        Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.newarrow)).into(this.center_card_one);
        Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.newarrow)).into(this.center_card_two);
        if (i8 != 3) {
            final int i9 = i;
            final int i10 = i2;
            final int i11 = i3;
            final int i12 = i4;
            CountDownTimer r0 = new CountDownTimer(12000, 200) {
                public void onTick(long j) {
                    TextView access$200 = SpinTheBottleActivity.this.coutdown;
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(j / 100);
                    access$200.setText(sb.toString());
                    long j2 = j % 2;
                    Integer valueOf = Integer.valueOf(R.drawable.newarrow);
                    Integer valueOf2 = Integer.valueOf(R.drawable.secondarrow);
                    if (j2 == 0) {
                        SpinTheBottleActivity.this.center_card_one.setVisibility(View.VISIBLE);
                        Glide.with(SpinTheBottleActivity.this.getApplicationContext()).load(valueOf).into(SpinTheBottleActivity.this.center_card_one);
                        Glide.with(SpinTheBottleActivity.this.getApplicationContext()).load(valueOf2).into(SpinTheBottleActivity.this.center_card_two);
                        if (i9 == 3) {
                            SpinTheBottleActivity.this.liner1.setBackgroundColor(Color.parseColor("#2833ff"));
                        }
                        if (i10 == 3) {
                            SpinTheBottleActivity.this.liner2.setBackgroundColor(Color.parseColor("#FF7F50"));
                        }
                        if (i11 == 3) {
                            SpinTheBottleActivity.this.liner3.setBackgroundColor(Color.parseColor("#FF0000"));
                        }
                        if (i12 == 3) {
                            SpinTheBottleActivity.this.liner4.setBackgroundColor(Color.parseColor("#32CD32"));
                            return;
                        }
                        return;
                    }
                    SpinTheBottleActivity.this.center_card_two.setVisibility(View.VISIBLE);
                    Glide.with(SpinTheBottleActivity.this.getApplicationContext()).load(valueOf2).into(SpinTheBottleActivity.this.center_card_one);
                    Glide.with(SpinTheBottleActivity.this.getApplicationContext()).load(valueOf).into(SpinTheBottleActivity.this.center_card_two);
                    String str = "#FFFAFA";
                    if (i9 == 3) {
                        SpinTheBottleActivity.this.liner1.setBackgroundColor(Color.parseColor(str));
                    }
                    if (i10 == 3) {
                        SpinTheBottleActivity.this.liner2.setBackgroundColor(Color.parseColor(str));
                    }
                    if (i11 == 3) {
                        SpinTheBottleActivity.this.liner3.setBackgroundColor(Color.parseColor(str));
                    }
                    if (i12 == 3) {
                        SpinTheBottleActivity.this.liner4.setBackgroundColor(Color.parseColor(str));
                    }
                }

                public void onFinish() {
                    int i;
                    int i2;
                    int i3;
                    int i4;
                    SpinTheBottleActivity.this.coutdown.setText("");
                    if (SpinTheBottleActivity.this.gameCount % 4 == 0) {
                        i4 = SpinTheBottleActivity.this.combo1[0];
                        i3 = SpinTheBottleActivity.this.combo1[1];
                        i2 = SpinTheBottleActivity.this.combo1[2];
                        i = SpinTheBottleActivity.this.combo1[3];
                    } else if (SpinTheBottleActivity.this.gameCount % 4 == 1) {
                        i4 = SpinTheBottleActivity.this.combo2[0];
                        i3 = SpinTheBottleActivity.this.combo2[1];
                        i2 = SpinTheBottleActivity.this.combo2[2];
                        i = SpinTheBottleActivity.this.combo2[3];
                    } else if (SpinTheBottleActivity.this.gameCount % 4 == 2) {
                        i4 = SpinTheBottleActivity.this.combo3[0];
                        i3 = SpinTheBottleActivity.this.combo3[1];
                        i2 = SpinTheBottleActivity.this.combo3[2];
                        i = SpinTheBottleActivity.this.combo3[3];
                    } else if (SpinTheBottleActivity.this.gameCount % 4 == 3) {
                        i4 = SpinTheBottleActivity.this.combo4[0];
                        i3 = SpinTheBottleActivity.this.combo4[1];
                        i2 = SpinTheBottleActivity.this.combo4[2];
                        i = SpinTheBottleActivity.this.combo4[3];
                    } else {
                        i4 = 1;
                        i3 = 2;
                        i2 = 3;
                        i = 4;
                    }
                    SpinTheBottleActivity.this.chorsipahi(i4, i3, i2, i);
                    final int nextInt = new Random().nextInt(2);
                    CountDownTimer r6 = new CountDownTimer(5000, 1000) {
                        public void onTick(long j) {
                            TextView access$200 = SpinTheBottleActivity.this.coutdown;
                            StringBuilder sb = new StringBuilder();
                            sb.append("");
                            sb.append(j / 1000);
                            access$200.setText(sb.toString());
                            if (nextInt == 0) {
                                SpinTheBottleActivity.this.willTheyKiss.setText("मंत्री ने चोर का पता लगाया !");
                                Glide.with(SpinTheBottleActivity.this.getApplicationContext()).load(Integer.valueOf(R.drawable.right)).into(SpinTheBottleActivity.this.center_card_one);
                                Glide.with(SpinTheBottleActivity.this.getApplicationContext()).load(Integer.valueOf(R.drawable.right)).into(SpinTheBottleActivity.this.center_card_two);
                                return;
                            }
                            SpinTheBottleActivity.this.willTheyKiss.setBackgroundColor(SupportMenu.CATEGORY_MASK);
                            SpinTheBottleActivity.this.willTheyKiss.setText("मंत्री चोर का पता नहीं लगा पाए !");
                            Glide.with(SpinTheBottleActivity.this.getApplicationContext()).load(Integer.valueOf(R.drawable.wrong)).into(SpinTheBottleActivity.this.center_card_one);
                            Glide.with(SpinTheBottleActivity.this.getApplicationContext()).load(Integer.valueOf(R.drawable.wrong)).into(SpinTheBottleActivity.this.center_card_two);
                        }

                        public void onFinish() {
                            int i;
                            int i2;
                            int i3;
                            SpinTheBottleActivity.this.coutdown.setText("");
                            int i4 = SpinTheBottleActivity.this.gameCount % 4;
                            Integer valueOf = Integer.valueOf(0);
                            if (i4 == 0) {
                                i3 = SpinTheBottleActivity.this.combo1[0];
                                i = SpinTheBottleActivity.this.combo1[1];
                                i2 = SpinTheBottleActivity.this.combo1[2];
                                int i5 = SpinTheBottleActivity.this.combo1[3];
                            } else if (SpinTheBottleActivity.this.gameCount % 4 == 1) {
                                i3 = SpinTheBottleActivity.this.combo2[0];
                                i = SpinTheBottleActivity.this.combo2[1];
                                i2 = SpinTheBottleActivity.this.combo2[2];
                                int i6 = SpinTheBottleActivity.this.combo2[3];
                            } else if (SpinTheBottleActivity.this.gameCount % 4 == 2) {
                                i3 = SpinTheBottleActivity.this.combo3[0];
                                i = SpinTheBottleActivity.this.combo3[1];
                                i2 = SpinTheBottleActivity.this.combo3[2];
                                int i7 = SpinTheBottleActivity.this.combo3[3];
                            } else if (SpinTheBottleActivity.this.gameCount % 4 == 3) {
                                i3 = SpinTheBottleActivity.this.combo4[0];
                                i = SpinTheBottleActivity.this.combo4[1];
                                i2 = SpinTheBottleActivity.this.combo4[2];
                                int i8 = SpinTheBottleActivity.this.combo4[3];
                            } else {
                                i3 = 1;
                                i2 = 3;
                                i = 2;
                            }
                            Glide.with(SpinTheBottleActivity.this.getApplicationContext()).load(valueOf).into(SpinTheBottleActivity.this.center_card_one);
                            Glide.with(SpinTheBottleActivity.this.getApplicationContext()).load(valueOf).into(SpinTheBottleActivity.this.center_card_two);
                            SpinTheBottleActivity.this.center_card_one.setVisibility(View.VISIBLE);
                            SpinTheBottleActivity.this.center_card_two.setVisibility(View.VISIBLE);
                            SpinTheBottleActivity.this.willTheyKiss.setBackgroundColor(-16711936);
                            SpinTheBottleActivity.this.reusableCode(nextInt, i3, i, i2);
                        }
                    };
                    r6.start();
                }
            };
            r0.start();
            PrepareLeaderBoard();
        }
    }

    public void reusableCode(int i, int i2, int i3, int i4) {
        String str = "500 PTS";
        if (i == 0) {
            this.willTheyKiss.setText("मंत्री ने चोर का पता लगाया !");
            Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.right)).into(this.center_card_one);
            Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.right)).into(this.center_card_two);
            if (i2 == 2) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss1Count(0);
            } else if (i3 == 2) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss2Count(0);
            } else if (i4 == 2) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss3Count(0);
            } else {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss4Count(0);
            }
            if (i2 == 3) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss1Count(500);
                this.one_point.setText(str);
                this.playerAlert1.show();
            } else if (i3 == 3) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss2Count(500);
                this.two_point.setText(str);
                this.playerAlert2.show();
            } else if (i4 == 3) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss3Count(500);
                this.three_point.setText(str);
                this.playerAlert3.show();
            } else {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss4Count(500);
                this.four_point.setText(str);
                this.playerAlert4.show();
            }
        } else {
            this.willTheyKiss.setBackgroundColor(SupportMenu.CATEGORY_MASK);
            this.willTheyKiss.setText("मंत्री चोर का पता नहीं लगा पाए !");
            Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.wrong)).into(this.center_card_one);
            Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.wrong)).into(this.center_card_two);
            if (i2 == 3) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss1Count(0);
            } else if (i3 == 3) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss2Count(0);
            } else if (i4 == 3) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss3Count(0);
            } else {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss4Count(0);
            }
            if (i2 == 2) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss1Count(500);
                this.one_point.setText(str);
                this.playerAlert1.show();
            } else if (i3 == 2) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss2Count(500);
                this.two_point.setText(str);
                this.playerAlert2.show();
            } else if (i4 == 2) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss3Count(500);
                this.three_point.setText(str);
                this.playerAlert3.show();
            } else {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss4Count(500);
                this.four_point.setText(str);
                this.playerAlert4.show();
            }
        }
        String str2 = "300 PTS";
        if (i2 == 4) {
            SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss1Count(300);
            this.one_point.setText(str2);
        } else if (i3 == 4) {
            SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss2Count(300);
            this.two_point.setText(str2);
        } else if (i4 == 4) {
            SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss3Count(300);
            this.three_point.setText(str2);
        } else {
            SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss4Count(300);
            this.four_point.setText(str2);
        }
        PrepareLeaderBoard();
    }

    public void chorsipahi(int i, int i2, int i3, int i4) {
        Integer valueOf = Integer.valueOf(R.drawable.sipahi);
        Integer valueOf2 = Integer.valueOf(R.drawable.chor);
        if (i == 2) {
            Glide.with(getApplicationContext()).load(valueOf2).into(this.center_card_three);
            Glide.with(getApplicationContext()).load(valueOf2).into(this.card_one_img);
        } else if (i == 4) {
            Glide.with(getApplicationContext()).load(valueOf).into(this.center_card_three);
            Glide.with(getApplicationContext()).load(valueOf).into(this.card_one_img);
        }
        if (i2 == 2) {
            Glide.with(getApplicationContext()).load(valueOf2).into(this.center_card_three);
            Glide.with(getApplicationContext()).load(valueOf2).into(this.card_two_img);
        } else if (i2 == 4) {
            Glide.with(getApplicationContext()).load(valueOf).into(this.center_card_three);
            Glide.with(getApplicationContext()).load(valueOf).into(this.card_two_img);
        }
        if (i3 == 2) {
            Glide.with(getApplicationContext()).load(valueOf2).into(this.center_card_four);
            Glide.with(getApplicationContext()).load(valueOf2).into(this.card_three_img);
        } else if (i3 == 4) {
            Glide.with(getApplicationContext()).load(valueOf).into(this.center_card_four);
            Glide.with(getApplicationContext()).load(valueOf).into(this.card_three_img);
        }
        if (i4 == 2) {
            Glide.with(getApplicationContext()).load(valueOf2).into(this.center_card_four);
            Glide.with(getApplicationContext()).load(valueOf2).into(this.card_four_img);
        } else if (i4 == 4) {
            Glide.with(getApplicationContext()).load(valueOf).into(this.center_card_four);
            Glide.with(getApplicationContext()).load(valueOf).into(this.card_four_img);
        }
    }

    public void pointDistributionAndRightWrong(int i, int i2, int i3, int i4) {
        String str = "500 PTS";
        if (i == 0) {
            this.willTheyKiss.setText("मंत्री ने चोर का पता लगाया !");
            Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.right)).into(this.center_card_one);
            Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.right)).into(this.center_card_two);
            if (i2 == 2) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss1Count(0);
            } else if (i3 == 2) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss2Count(0);
            } else if (i4 == 2) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss3Count(0);
            } else {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss4Count(0);
            }
            if (i2 == 3) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss1Count(500);
                this.one_point.setText(str);
            } else if (i3 == 3) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss2Count(500);
                this.two_point.setText(str);
            } else if (i4 == 3) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss3Count(500);
                this.three_point.setText(str);
            } else {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss4Count(500);
                this.four_point.setText(str);
            }
        } else {
            this.willTheyKiss.setBackgroundColor(SupportMenu.CATEGORY_MASK);
            this.willTheyKiss.setText("मंत्री चोर का पता नहीं लगा पाए !");
            Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.wrong)).into(this.center_card_one);
            Glide.with(getApplicationContext()).load(Integer.valueOf(R.drawable.wrong)).into(this.center_card_two);
            if (i2 == 3) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss1Count(0);
            } else if (i3 == 3) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss2Count(0);
            } else if (i4 == 3) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss3Count(0);
            } else {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss4Count(0);
            }
            if (i2 == 2) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss1Count(500);
                this.one_point.setText(str);
            } else if (i3 == 2) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss2Count(500);
                this.two_point.setText(str);
            } else if (i4 == 2) {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss3Count(500);
                this.three_point.setText(str);
            } else {
                SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss4Count(500);
                this.four_point.setText(str);
            }
        }
        String str2 = "300 PTS";
        if (i2 == 4) {
            SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss1Count(300);
            this.one_point.setText(str2);
        } else if (i3 == 4) {
            SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss2Count(300);
            this.two_point.setText(str2);
        } else if (i4 == 4) {
            SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss3Count(300);
            this.three_point.setText(str2);
        } else {
            SpinTheBottleAppPreferences.getInstance(getApplicationContext()).incrementKiss4Count(300);
            this.four_point.setText(str2);
        }
        PrepareLeaderBoard();
    }
}
