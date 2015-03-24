package com.wt.sampleapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by Kenumir on 2015-03-18.
 */
public class SampleDialog extends DialogFragment {

	public static interface OnDialogOkClick {
		public void onOkClick();
	}

	private DialogInterface.OnClickListener onOkClick;

	public SampleDialog() {}

	public static SampleDialog newInstance() {
		SampleDialog frag = new SampleDialog();
		Bundle args = new Bundle();
		frag.setArguments(args);
		return frag;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		//final ResultReceiver receiver = getArguments().getParcelable("receiver");

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setMessage("Sample message")
			.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					try {
						OnDialogOkClick ok = (OnDialogOkClick) getActivity();
						if (ok != null)
							ok.onOkClick();
					} catch (ClassCastException e) {}
					//ResultReceiver receiver = getArguments().getParcelable("receiver");
					//if (receiver != null)
					//	receiver.send(Activity.RESULT_OK, null);
					dialog.dismiss();
				}
			})
			.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.dismiss();
				}
			});
		return builder.create();
	}

	public DialogInterface.OnClickListener getOnOkClick() {
		return onOkClick;
	}

	public SampleDialog setOnOkClick(DialogInterface.OnClickListener onOkClick) {
		this.onOkClick = onOkClick;
		return this;
	}
}
