package br.com.alura.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResoucesUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable devolverDawable(Context context, String dawableEmTexto) {
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(dawableEmTexto, DRAWABLE, context.getPackageName());
        return resources.getDrawable(idDoDrawable);
    }
}
