package br.com.felipemsa.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.TextView;
import br.com.felipemsa.lib.interfaces.Roboto;
import br.com.felipemsa.robototextview.R;

public class RobotoTextView extends TextView implements Roboto
{
	private SparseArray<String> types = new SparseArray<String>();

	public RobotoTextView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		setRobotoTypeface(attrs);
	}

	public RobotoTextView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		setRobotoTypeface(attrs);
	}

	public RobotoTextView(Context context)
	{
		super(context);
	}

	private void init()
	{
		types.put(ROBOTO_THIN, PATH_ROBOTO_THIN);
		types.put(ROBOTO_LIGHT, PATH_ROBOTO_LIGHT);
		types.put(ROBOTO_REGULAR, PATH_ROBOTO_REGULAR);
		types.put(ROBOTO_MEDIUM, PATH_ROBOTO_MEDIUM);
		types.put(ROBOTO_BOLD, PATH_ROBOTO_BOLD);
		types.put(ROBOTO_BLACK, PATH_ROBOTO_BLACK);
		types.put(ROBOTO_COND_LIGHT, PATH_ROBOTO_COND_LIGHT);
		types.put(ROBOTO_COND_REGULAR, PATH_ROBOTO_COND_REGULAR);
		types.put(ROBOTO_COND_BOLD, PATH_ROBOTO_COND_BOLD);
	}

	private void setRobotoTypeface(AttributeSet attrs)
	{
		init();

		TypedArray t = getContext().obtainStyledAttributes(attrs, R.styleable.robotoTypefaces);
		int type = t.getInt(R.styleable.robotoTypefaces_type, ROBOTO_REGULAR);

		Typeface tf = Typeface.createFromAsset(getContext().getAssets(), types.get(type, PATH_ROBOTO_REGULAR));
		setTypeface(tf);

		t.recycle();
	}

}
