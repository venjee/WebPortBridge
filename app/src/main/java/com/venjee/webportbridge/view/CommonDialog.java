package com.venjee.webportbridge.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.venjee.webportbridge.R;

public class CommonDialog extends Dialog {

    public CommonDialog(Context paramContext) {
        super(paramContext);
    }

    private CommonDialog(Context paramContext, int paramInt) {
        super(paramContext, paramInt);
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
            context = paramContext;
        }

        public CommonDialog create() {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final CommonDialog dialog = new CommonDialog(this.context, R.style.Dialog);
            View view = inflater.inflate(R.layout.dialog_normal_layout, null);
            dialog.addContentView(view, new ViewGroup.LayoutParams(-1, -2));
            ((TextView) view.findViewById(R.id.title)).setText(this.title);
            if (positiveButtonText != null) {

                ((Button) view.findViewById(R.id.positiveButton)).setText(this.positiveButtonText);

                if (positiveButtonClickListener != null) {
                    (view.findViewById(R.id.positiveButton)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View paramView) {
                            positiveButtonClickListener.onClick(dialog, -1);
                        }
                    });
                }

                ((Button) view.findViewById(R.id.negativeButton)).setText(this.negativeButtonText);

                if (negativeButtonClickListener != null){
                    (view.findViewById(R.id.negativeButton)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View paramView) {
                            CommonDialog.Builder.this.negativeButtonClickListener.onClick(dialog, -2);
                        }
                    });
                }

                if (message != null) {
                    ((TextView)view.findViewById(R.id.message)).setText(this.message);
                }
            }else {
                dialog.setContentView(view);
                view.findViewById(R.id.positiveButton).setVisibility(View.GONE);
                view.findViewById(R.id.negativeButton).setVisibility(View.GONE);
                if(contentView != null) {
                    ((LinearLayout)view.findViewById(R.id.content)).removeAllViews();
                    ((LinearLayout) view.findViewById(R.id.content)).addView(this.contentView, new ViewGroup.LayoutParams(-1, -1));
                }
            }
            return dialog;
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
}