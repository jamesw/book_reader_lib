package uk.co.pjmobile.mobile_apps.page_turner_reader;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import pageturner.Util;
import pl.polidea.treeview.AbstractTreeViewAdapter;
import pl.polidea.treeview.TreeNodeInfo;
import pl.polidea.treeview.TreeStateManager;
import uk.co.pjmobile.mobile_apps.page_turner_reader.view.BookView;

public class TocAdapter extends AbstractTreeViewAdapter<Long> {

	public TocAdapter(Activity activity,
			TreeStateManager<Long> treeStateManager, int numberOfLevels) {
		super(activity, treeStateManager, numberOfLevels);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return getTreeId(position);
	}

    @Override
    public View getNewChildView(final TreeNodeInfo<Long> treeNodeInfo) {
        final LinearLayout viewLayout = (LinearLayout) getActivity()
                .getLayoutInflater().inflate(R.layout.toc_list_item, null);
        return updateView(viewLayout, treeNodeInfo);
    }

    @Override
    public LinearLayout updateView(final View view,
            final TreeNodeInfo<Long> treeNodeInfo) {
        final LinearLayout viewLayout = (LinearLayout) view;
        final TextView descriptionView = (TextView) viewLayout
                .findViewById(R.id.toc_list_item_description);
        final TextView levelView = (TextView) viewLayout
                .findViewById(R.id.toc_list_item_level);
        

//		if (tocList == null || tocList.isEmpty()) {
//		}else{
		
//			final CharSequence[] items = new CharSequence[tocList.size()];
			
//			for (int i = 0; i < items.length; i++) {
//				items[i] = tocList.get(i).getTitle();
//			}

//		}
        descriptionView.setText(TocActivity.tocList.get(treeNodeInfo.getId().intValue()).getTitle());
//        descriptionView.setText(getDescription(treeNodeInfo.getId()));
        levelView.setText(" ");
//        levelView.setText(Integer.toString(treeNodeInfo.getLevel()));
//        final CheckBox box = (CheckBox) viewLayout
//                .findViewById(R.id.demo_list_checkbox);
//        box.setTag(treeNodeInfo.getId());
//        if (treeNodeInfo.isWithChildren()) {
//            box.setVisibility(View.GONE);
//        } else {
//            box.setVisibility(View.VISIBLE);
//            box.setChecked(selected.contains(treeNodeInfo.getId()));
//        }
//        box.setOnCheckedChangeListener(onCheckedChange);
        return viewLayout;
 	}

    @Override
    public void handleItemClick(final View view, final Object id) {
        final Long longId = (Long) id;
        final TreeNodeInfo<Long> info = getManager().getNodeInfo(longId);
        ((TocActivity) this.activity).pageSelected(longId.intValue());
        //final List<BookView.TocEntry> tocList = ReadingActivity.bookView.getTableOfContents();
        //Util.log_debug_message("@@@@ Navigate to " + tocList.get(longId.intValue()).getHref());
//        ReadingActivity.bookView.navigateTo(TocActivity.tocList.get(longId.intValue()).getHref());        
//        this.activity.finish();
 //   	Util.toast(view.getContext(), info.toString());
 //       if (info.isWithChildren()) {
 //           super.handleItemClick(view, id);
 //       } else {
 //       	Util.toast(view.getContext(), "Clicked");
 //       }
        
    }
    
}
