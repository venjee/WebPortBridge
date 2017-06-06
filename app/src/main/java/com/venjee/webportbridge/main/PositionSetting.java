package com.venjee.webportbridge.main;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.skyworthdigital.sky2dlauncher.tools.SysPropHelper;
import java.io.PrintStream;

public class PositionSetting extends Activity
{
  private static final float MPERCENT = 0.9F;
  private static final int OUTPUT1080_FULL_HEIGHT = 1079;
  private static final int OUTPUT1080_FULL_WIDTH = 1919;
  private static final int OUTPUT480_FULL_HEIGHT = 479;
  private static final int OUTPUT480_FULL_WIDTH = 719;
  private static final int OUTPUT4K2KSMPTE_FULL_HEIGHT = 2159;
  private static final int OUTPUT4K2KSMPTE_FULL_WIDTH = 4095;
  private static final int OUTPUT4K2K_FULL_HEIGHT = 2159;
  private static final int OUTPUT4K2K_FULL_WIDTH = 3839;
  private static final int OUTPUT576_FULL_HEIGHT = 575;
  private static final int OUTPUT576_FULL_WIDTH = 719;
  private static final int OUTPUT720_FULL_HEIGHT = 719;
  private static final int OUTPUT720_FULL_WIDTH = 1279;
  private static final String TAG = "PositionSetting";
  private static final int ZOOM_PIXEL = 2;
  TextView mAdj;
  private View mContainView;
  private PositionCoor mCurrentPosition = new PositionCoor();
  private RelativeLayout mLoadingRlyt;
  private PositionCoor mOriginalPosition = new PositionCoor();
  private Outputsize mOutputSize = new Outputsize();

  private void initOutputsize()
  {
    String str = SysPropHelper.getCurrentOutputMode();
    if (str.contains("480"))
    {
      mOutputSize.height = OUTPUT480_FULL_HEIGHT;
      mOutputSize.width = OUTPUT480_FULL_WIDTH;
      return;
    }
    if (str.contains("576"))
    {
        mOutputSize.height = OUTPUT576_FULL_HEIGHT;
        mOutputSize.width = OUTPUT576_FULL_WIDTH;
      return;
    }
    if (str.contains("720"))
    {
        mOutputSize.height = OUTPUT720_FULL_HEIGHT;
        mOutputSize.width = OUTPUT720_FULL_WIDTH;
      return;
    }
    if (str.contains("1080"))
    {
        mOutputSize.height = OUTPUT1080_FULL_HEIGHT;
        mOutputSize.width = OUTPUT1080_FULL_WIDTH;
      return;
    }
    if (str.contains("2160"))
    {
        mOutputSize.height = OUTPUT4K2K_FULL_HEIGHT;
        mOutputSize.width = OUTPUT4K2K_FULL_WIDTH;
      return;
    }
    if (str.contains("smpte"))
    {
        mOutputSize.height = OUTPUT4K2KSMPTE_FULL_HEIGHT;
        mOutputSize.width = OUTPUT4K2KSMPTE_FULL_WIDTH;
      return;
    }
      mOutputSize.height = OUTPUT720_FULL_HEIGHT;
      mOutputSize.width = OUTPUT720_FULL_WIDTH;
  }

  private void initPosition()
  {
    initOutputsize();
    int[] arrayOfInt = SysPropHelper.getCurrentScreenPosition();
    PositionCoor.access$402(this.mOriginalPosition, arrayOfInt[0]);
    PositionCoor.access$502(this.mOriginalPosition, arrayOfInt[1]);
    PositionCoor.access$602(this.mOriginalPosition, this.mOutputSize.width - this.mOriginalPosition.left);
    PositionCoor.access$702(this.mOriginalPosition, this.mOutputSize.height - this.mOriginalPosition.top);
    PositionCoor.access$402(this.mCurrentPosition, arrayOfInt[0]);
    PositionCoor.access$502(this.mCurrentPosition, arrayOfInt[1]);
    PositionCoor.access$602(this.mCurrentPosition, this.mOutputSize.width - this.mCurrentPosition.left);
    PositionCoor.access$702(this.mCurrentPosition, this.mOutputSize.height - this.mCurrentPosition.top);
  }

  private void keyCodeDown()
  {
    if (this.mCurrentPosition.top + 2 < (int)(this.mOutputSize.height * 0.1F))
    {
      PositionCoor localPositionCoor = this.mCurrentPosition;
      PositionCoor.access$502(localPositionCoor, localPositionCoor.top + 2);
      PositionCoor.access$702(localPositionCoor, localPositionCoor.bottom - 2);
      this.mCurrentPosition = localPositionCoor;
    }
    while (true)
    {
      setPosition(this.mCurrentPosition.left, this.mCurrentPosition.top, this.mCurrentPosition.right, this.mCurrentPosition.bottom, 0);
      return;
      PositionCoor.access$702(this.mCurrentPosition, (int)(this.mOutputSize.height * 0.9F));
      PositionCoor.access$502(this.mCurrentPosition, (int)(this.mOutputSize.height * 0.1F));
    }
  }

  private void keyCodeLeft()
  {
    if (this.mCurrentPosition.right - 2 > (int)(this.mOutputSize.width * 0.9F))
    {
      PositionCoor localPositionCoor = this.mCurrentPosition;
      PositionCoor.access$402(localPositionCoor, localPositionCoor.left + 2);
      PositionCoor.access$602(localPositionCoor, localPositionCoor.right - 2);
      this.mCurrentPosition = localPositionCoor;
    }
    while (true)
    {
      setPosition(this.mCurrentPosition.left, this.mCurrentPosition.top, this.mCurrentPosition.right, this.mCurrentPosition.bottom, 0);
      return;
      PositionCoor.access$602(this.mCurrentPosition, (int)(this.mOutputSize.width * 0.9F));
      PositionCoor.access$402(this.mCurrentPosition, (int)(this.mOutputSize.width * 0.1F));
    }
  }

  private void keyCodeRight()
  {
    if (this.mCurrentPosition.right < this.mOutputSize.width)
    {
      PositionCoor localPositionCoor = this.mCurrentPosition;
      PositionCoor.access$602(localPositionCoor, localPositionCoor.right + 2);
      PositionCoor.access$402(localPositionCoor, localPositionCoor.left - 2);
      this.mCurrentPosition = localPositionCoor;
    }
    while (true)
    {
      setPosition(this.mCurrentPosition.left, this.mCurrentPosition.top, this.mCurrentPosition.right, this.mCurrentPosition.bottom, 0);
      return;
      PositionCoor.access$402(this.mCurrentPosition, 0);
      PositionCoor.access$602(this.mCurrentPosition, this.mOutputSize.width);
    }
  }

  private void keyCodeUp()
  {
    if (this.mCurrentPosition.bottom < this.mOutputSize.height)
    {
      PositionCoor localPositionCoor = this.mCurrentPosition;
      PositionCoor.access$702(localPositionCoor, localPositionCoor.bottom + 2);
      PositionCoor.access$502(localPositionCoor, localPositionCoor.top - 2);
      this.mCurrentPosition = localPositionCoor;
      setPosition(this.mCurrentPosition.left, this.mCurrentPosition.top, this.mCurrentPosition.right, this.mCurrentPosition.bottom, 0);
    }
    while (true)
    {
      setPosition(this.mCurrentPosition.left, this.mCurrentPosition.top, this.mCurrentPosition.right, this.mCurrentPosition.bottom, 0);
      return;
      PositionCoor.access$502(this.mCurrentPosition, 0);
      PositionCoor.access$702(this.mCurrentPosition, this.mOutputSize.height);
    }
  }

  private void savePosition()
  {
    if (!this.mOriginalPosition.equals(this.mCurrentPosition))
    {
      new BackgroundExc().execute(new String[0]);
      finish();
    }
  }

  private void setPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Log.i("PositionSetting", "setPosition() l:" + paramInt1 + "  t:" + paramInt2 + "  r:" + paramInt3 + "  b:" + paramInt4);
    SysPropHelper.setScreenPosition(paramInt1, paramInt3, paramInt4, paramInt2);
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    System.out.println("####keyevent:" + paramKeyEvent.getKeyCode());
    if (paramKeyEvent.getAction() == 0)
      switch (paramKeyEvent.getKeyCode())
      {
      default:
      case 19:
      case 20:
      case 21:
      case 22:
      }
    while (true)
    {
      return true;
      keyCodeUp();
      continue;
      keyCodeDown();
      continue;
      keyCodeLeft();
      continue;
      keyCodeRight();
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    SysPropHelper.InitDisplay(this);
    requestWindowFeature(1);
    setContentView(2130968607);
    this.mAdj = ((TextView)findViewById(2131427456));
    this.mAdj.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        PositionSetting.this.savePosition();
      }
    });
    initPosition();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  class BackgroundExc extends AsyncTask<String, String, String>
  {
    BackgroundExc()
    {
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      int i = PositionSetting.PositionCoor.access$400(PositionSetting.this.mCurrentPosition);
      int j = PositionSetting.PositionCoor.access$600(PositionSetting.this.mCurrentPosition);
      int k = PositionSetting.PositionCoor.access$700(PositionSetting.this.mCurrentPosition);
      int m = PositionSetting.PositionCoor.access$500(PositionSetting.this.mCurrentPosition);
      if ((j < i) || (k < m))
        return null;
      SysPropHelper.saveScreenPosition(i, j, k, m);
      return null;
    }
  }

  private class Outputsize
  {
    private int height;
    private int width;

    private Outputsize()
    {
    }
  }

  private class PositionCoor
  {
    private int bottom;
    private int left;
    private int right;
    private int top;

    private PositionCoor()
    {
    }

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof PositionCoor))
        return false;
      return (this.bottom == ((PositionCoor)paramObject).bottom)
              && (this.left == ((PositionCoor)paramObject).left)
              && (this.right == ((PositionCoor)paramObject).right)
              && (this.top == ((PositionCoor)paramObject).top);
    }
  }
}

/* Location:           C:\Users\venjee_shen\Desktop\反编译\dex2jar-2.0\classes-dex2jar.jar
 * Qualified Name:     com.skyworthdigital.sky2dlauncher.main.PositionSetting
 * JD-Core Version:    0.6.0
 */