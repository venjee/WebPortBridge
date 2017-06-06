package com.skyworthdigital.sky2dlauncher.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CommonDialg extends Dialog
{
  public CommonDialg(Context paramContext)
  {
    super(paramContext);
  }

  public CommonDialg(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
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

    public CommonDialg create()
    {
      Object localObject = (LayoutInflater)this.context.getSystemService("layout_inflater");
      CommonDialg localCommonDialg = new CommonDialg(this.context, 2131230911);
      localObject = ((LayoutInflater)localObject).inflate(2130968605, null);
      localCommonDialg.addContentView((View)localObject, new ViewGroup.LayoutParams(-1, -2));
      ((TextView)((View)localObject).findViewById(2131427373)).setText(this.title);
      if (this.positiveButtonText != null)
      {
        ((Button)((View)localObject).findViewById(2131427449)).setText(this.positiveButtonText);
        if (this.positiveButtonClickListener != null)
          ((Button)((View)localObject).findViewById(2131427449)).setOnClickListener(new View.OnClickListener(localCommonDialg)
          {
            public void onClick(View paramView)
            {
              CommonDialg.Builder.this.positiveButtonClickListener.onClick(this.val$dialog, -1);
            }
          });
        if (this.negativeButtonText == null)
          break label212;
        ((Button)((View)localObject).findViewById(2131427450)).setText(this.negativeButtonText);
        if (this.negativeButtonClickListener != null)
          ((Button)((View)localObject).findViewById(2131427450)).setOnClickListener(new View.OnClickListener(localCommonDialg)
          {
            public void onClick(View paramView)
            {
              CommonDialg.Builder.this.negativeButtonClickListener.onClick(this.val$dialog, -2);
            }
          });
        label168: if (this.message == null)
          break label226;
        ((TextView)((View)localObject).findViewById(2131427448)).setText(this.message);
      }
      while (true)
      {
        localCommonDialg.setContentView((View)localObject);
        return localCommonDialg;
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
}

/* Location:           C:\Users\venjee_shen\Desktop\反编译\dex2jar-2.0\classes-dex2jar.jar
 * Qualified Name:     com.skyworthdigital.sky2dlauncher.view.CommonDialg
 * JD-Core Version:    0.6.0
 */