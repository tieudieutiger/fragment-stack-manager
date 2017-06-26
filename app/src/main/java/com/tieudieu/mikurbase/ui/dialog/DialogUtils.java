package com.tieudieu.mikurbase.ui.dialog;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.tieudieu.mikurbase.R;


/**
 * Created by chienchieu on 11/08/2016.
 */
public class DialogUtils {

    /**
     * dialog confirm
     * - title
     * - content
     * - two button: positive & negative
     * + delete, ...
     * + cancel
     */
    public static void showDialogConfirmHaveTitle(
        Context context, int titleRes, int contentRes, int positiveRes, int negativeRes,
        MaterialDialog.SingleButtonCallback onPositiveClicked) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(context)
            .title(titleRes)
            .content(contentRes)
            .positiveText(positiveRes)
            .positiveColorRes(R.color.colorPrimary)
            .negativeColorRes(R.color.black)
            .negativeText(negativeRes)
            .onPositive(onPositiveClicked);
        MaterialDialog dialog = builder.build();
        dialog.show();
    }

    public static void showDialogConfirmHaveTitle(
            Context context, int titleRes, String content, int positiveRes, int negativeRes,
            MaterialDialog.SingleButtonCallback onPositiveClicked) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(context)
                .title(titleRes)
                .content(content)
                .positiveText(positiveRes)
                .negativeText(negativeRes)
                .positiveColorRes(R.color.colorPrimary)
                .negativeColorRes(R.color.black)
                .onPositive(onPositiveClicked);
        MaterialDialog dialog = builder.build();
        dialog.show();
    }

    public static void showDialogConfirm(
            Context context, int contentRes, int positiveRes,
            MaterialDialog.SingleButtonCallback onPositiveClicked) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(context)
                .content(contentRes)
                .positiveText(positiveRes)
                .positiveColorRes(R.color.colorPrimary)
                .negativeColorRes(R.color.black)
                .onPositive(onPositiveClicked);
        MaterialDialog dialog = builder.build();
        dialog.show();
    }

    /**
     * show notify
     */
    public static void showDialogNotify(Context context, int titleRes, int contentRes, int positiveRes) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(context)
                .title(titleRes)
                .content(contentRes)
                .positiveText(positiveRes)
                .positiveColorRes(R.color.colorPrimary);
        MaterialDialog dialog = builder.build();
        dialog.show();
    }

}
