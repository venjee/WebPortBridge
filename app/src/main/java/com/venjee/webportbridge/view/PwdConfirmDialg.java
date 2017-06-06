package com.skyworthdigital.sky2dlauncher.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PwdConfirmDialg extends Dialog
{
  private Button mBtn;
  private OnPwdConfirm mOnConfirm = null;
  private EditText mPwd;
  private TextView mTitle;

  public PwdConfirmDialg(Context paramContext)
  {
    super(paramContext);
    requestWindowFeature(1);
    setContentView(2130968604);
    this.mTitle = ((TextView)findViewById(2131427444));
    this.mPwd = ((EditText)findViewById(2131427445));
    this.mBtn = ((Button)findViewById(2131427446));
    this.mBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        if (PwdConfirmDialg.this.mOnConfirm != null)
        {
          PwdConfirmDialg.this.dismiss();
          PwdConfirmDialg.this.mOnConfirm.onConfirm(PwdConfirmDialg.this.mPwd.getText().toString());
        }
      }
    });
  }

  public PwdConfirmDialg(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }

  public PwdConfirmDialg(Context paramContext, String paramString, OnPwdConfirm paramOnPwdConfirm)
  {
    this(paramContext);
    this.mTitle.setText(paramString);
    this.mOnConfirm = paramOnPwdConfirm;
  }

  public void setMsg(String paramString)
  {
    this.mTitle.setText(paramString);
  }

  public static class Builder
  {
    private View contentView;
    private Context context;
    private String message;
    private DialogInterface.OnClickListener negativeButtonClickListener;
    private String negativeButtonText;
    private DialogInterface.OnClickListener positiveButtonClickListener;
    private String positiveButtonText;
    private String title;

    public Builder(Context paramContext)
    {
      this.context = paramContext;
    }

    public PwdConfirmDialg create()
    {
      Object localObject = (LayoutInflater)this.context.getSystemService("layout_inflater");
      PwdConfirmDialg localPwdConfirmDialg = new PwdConfirmDialg(this.context, 2131230911);
      localObject = ((LayoutInflater)localObject).inflate(2130968604, null);
      localPwdConfirmDialg.addContentView((View)localObject, new ViewGroup.LayoutParams(-1, -2));
      ((TextView)((View)localObject).findViewById(2131427373)).setText(this.title);
      if (this.positiveButtonText != null)
      {
        ((Button)((View)localObject).findViewById(2131427449)).setText(this.positiveButtonText);
        if (this.positiveButtonClickListener != null)
          ((Button)((View)localObject).findViewById(2131427449)).setOnClickListener(new View.OnClickListener(localPwdConfirmDialg)
          {
            public void onClick(View paramView)
            {
              PwdConfirmDialg.Builder.this.positiveButtonClickListener.onClick(this.val$dialog, -1);
            }
          });
        if (this.negativeButtonText == null)
          break label212;
        ((Button)((View)localObject).findViewById(2131427450)).setText(this.negativeButtonText);
        if (this.negativeButtonClickListener != null)
          ((Button)((View)localObject).findViewById(2131427450)).setOnClickListener(new View.OnClickListener(localPwdConfirmDialg)
          {
            public void onClick(View paramView)
            {
              PwdConfirmDialg.Builder.this.negativeButtonClickListener.onClick(this.val$dialog, -2);
            }
          });
        label168: if (this.message == null)
          break label226;
        ((TextView)((View)localObject).findViewById(2131427448)).setText(this.message);
      }
      while (true)
      {
        localPwdConfirmDialg.setContentView((View)localObject);
        return localPwdConfirmDialg;
        ((View)localObject).findViewById(2131427449).setVisibility(8);
        break;
        label212: ((View)localObject).findViewById(2131427450).setVisibility(8);
        break label168;
        label226: if (this.contentView == null)
          continue;
        ((LinearLayout)((View)localObject).findViewById(2131427447)).removeAllViews();
        ((LinearLayout)((View)localObject).findViewById(2131427447)).addView(this.contentView, new ViewGroup.LayoutParams(-1, -1));
      }
    }

    public Builder setContentView(View paramView)
    {
      this.contentView = paramView;
      return this;
    }

    public Builder setMessage(int paramInt)
    {
      this.message = ((String)this.context.getText(paramInt));
      return this;
    }

    public Builder setMessage(String paramString)
    {
      this.message = paramString;
      return this;
    }

    public Builder setNegativeButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.negativeButtonText = ((String)this.context.getText(paramInt));
      this.negativeButtonClickListener = paramOnClickListener;
      return this;
    }

    public Builder setNegativeButton(String paramString, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.negativeButtonText = paramString;
      this.negativeButtonClickListener = paramOnClickListener;
      return this;
    }

    public Builder setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.positiveButtonText = ((String)this.context.getText(paramInt));
      this.positiveButtonClickListener = paramOnClickListener;
      return this;
    }

    public Builder setPositiveButton(String paramString, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.positiveButtonText = paramString;
      this.positiveButtonClickListener = paramOnClickListener;
      return this;
    }

    public Builder setTitle(int paramInt)
    {
      this.title = ((String)this.context.getText(paramInt));
      return this;
    }

    public Builder setTitle(String paramString)
    {
      this.title = paramString;
      return this;
    }
  }

  public static abstract interface OnPwdConfirm
  {
    public abstract void onConfirm(String paramString);
  }
}

/* Location:           C:\Users\venjee_shen\Desktop\反编译\dex2jar-2.0\classes-dex2jar.jar
 * Qualified Name:     com.skyworthdigital.sky2dlauncher.view.PwdConfirmDialg
 * JD-Core Version:    0.6.0
 */