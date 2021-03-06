package com.venjee.webportbridge.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.venjee.webportbridge.R;

public class PwdConfirmDialg extends Dialog {
    private Button mBtn;
    private OnPwdConfirm mOnConfirm = null;
    private EditText mPwd;
    private TextView mTitle;

    public PwdConfirmDialg(Context paramContext) {
        super(paramContext);
        requestWindowFeature(1);
        setContentView(R.layout.dialog_input_layou);
        this.mTitle = ((TextView) findViewById(R.id.dialog_tile));
        this.mPwd = ((EditText) findViewById(R.id.dialog_pwd));
        this.mBtn = ((Button) findViewById(R.id.dialog_btn));
        this.mBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramView) {
                if (PwdConfirmDialg.this.mOnConfirm != null) {
                    PwdConfirmDialg.this.dismiss();
                    PwdConfirmDialg.this.mOnConfirm.onConfirm(PwdConfirmDialg.this.mPwd.getText().toString());
                }
            }
        });
    }

    public PwdConfirmDialg(Context paramContext, int paramInt) {
        super(paramContext, paramInt);
    }

    public PwdConfirmDialg(Context paramContext, String paramString, OnPwdConfirm paramOnPwdConfirm) {
        this(paramContext);
        this.mTitle.setText(paramString);
        this.mOnConfirm = paramOnPwdConfirm;
    }

    public void setMsg(String paramString) {
        this.mTitle.setText(paramString);
    }

    public static class Builder {
        private View contentView;
        private Context context;
        private String message;
        private DialogInterface.OnClickListener negativeButtonClickListener;
        private String negativeButtonText;
        private DialogInterface.OnClickListener positiveButtonClickListener;
        private String positiveButtonText;
        private String title;

        public Builder(Context paramContext) {
            this.context = paramContext;
        }

        public PwdConfirmDialg create() {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final PwdConfirmDialg localPwdConfirmDialg = new PwdConfirmDialg(this.context, R.style.Dialog);
            View view = inflater.inflate(R.layout.dialog_input_layou, null);
            localPwdConfirmDialg.addContentView(view, new ViewGroup.LayoutParams(-1, -2));
            ((TextView) view.findViewById(R.id.title)).setText(this.title);
            if (this.positiveButtonText != null) {
                ((Button) view.findViewById(R.id.positiveButton)).setText(this.positiveButtonText);
                if (this.positiveButtonClickListener != null)
                    (view.findViewById(R.id.positiveButton)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View paramView) {
                            PwdConfirmDialg.Builder.this.positiveButtonClickListener.onClick(localPwdConfirmDialg, -1);
                        }
                    });
                if (this.negativeButtonText == null) {
                    ((Button) view.findViewById(R.id.negativeButton)).setText(this.negativeButtonText);
                }

                if (this.negativeButtonClickListener != null) {
                    (view.findViewById(R.id.negativeButton)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View paramView) {
                            PwdConfirmDialg.Builder.this.negativeButtonClickListener.onClick(localPwdConfirmDialg, -2);
                        }
                    });
                }
                if (this.message != null) {
                    ((TextView) view.findViewById(R.id.message)).setText(this.message);
                }
            } else {
                localPwdConfirmDialg.setContentView(view);
                view.findViewById(R.id.positiveButton).setVisibility(View.GONE);
                view.findViewById(R.id.negativeButton).setVisibility(View.GONE);
                if (this.contentView != null) {
                    ((LinearLayout) view.findViewById(R.id.content)).removeAllViews();
                    ((LinearLayout) view.findViewById(R.id.content)).addView(this.contentView, new ViewGroup.LayoutParams(-1, -1));
                }
            }
            return localPwdConfirmDialg;
        }

        public Builder setContentView(View paramView) {
            this.contentView = paramView;
            return this;
        }

        public Builder setMessage(int paramInt) {
            this.message = ((String) this.context.getText(paramInt));
            return this;
        }

        public Builder setMessage(String paramString) {
            this.message = paramString;
            return this;
        }

        public Builder setNegativeButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener) {
            this.negativeButtonText = ((String) this.context.getText(paramInt));
            this.negativeButtonClickListener = paramOnClickListener;
            return this;
        }

        public Builder setNegativeButton(String paramString, DialogInterface.OnClickListener paramOnClickListener) {
            this.negativeButtonText = paramString;
            this.negativeButtonClickListener = paramOnClickListener;
            return this;
        }

        public Builder setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener) {
            this.positiveButtonText = ((String) this.context.getText(paramInt));
            this.positiveButtonClickListener = paramOnClickListener;
            return this;
        }

        public Builder setPositiveButton(String paramString, DialogInterface.OnClickListener paramOnClickListener) {
            this.positiveButtonText = paramString;
            this.positiveButtonClickListener = paramOnClickListener;
            return this;
        }

        public Builder setTitle(int paramInt) {
            this.title = ((String) this.context.getText(paramInt));
            return this;
        }

        public Builder setTitle(String paramString) {
            this.title = paramString;
            return this;
        }
    }

    public static abstract interface OnPwdConfirm {
        public abstract void onConfirm(String paramString);
    }
}