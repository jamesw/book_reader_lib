package uk.co.pjmobile.mobile_apps.page_turner_reader;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pageturner.Util;
import pl.polidea.treeview.InMemoryTreeStateManager;
import pl.polidea.treeview.TreeBuilder;
import pl.polidea.treeview.TreeStateManager;
import pl.polidea.treeview.TreeViewList;
import uk.co.pjmobile.mobile_apps.page_turner_reader.view.BookView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class TocActivity extends Activity {
    private static TreeStateManager<Long> manager = null;
//    private static final int[] DEMO_NODES = new int[] { 0, 0, 1, 1, 1, 2, 2, 1,
//        1, 2, 1, 0, 0, 0, 1, 2, 3, 2, 0, 0, 1, 2, 0, 1, 2, 0, 1 };
    private static final int LEVEL_NUMBER = 5;
    private static TreeViewList treeView;
    TocAdapter tocAdapter;
	public static List<BookView.TocEntry> tocList = ReadingActivity.bookView.getTableOfContents();
	private BookView bookView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.bookView = ReadingActivity.bookView;
        //Util.log_debug_message("@@@@ - Calling Book view child count is " + ReadingActivity.bookView.getChildCount());
        if (savedInstanceState == null) {
            manager = new InMemoryTreeStateManager<Long>();
            final TreeBuilder<Long> treeBuilder = new TreeBuilder<Long>(manager);
    		TocActivity.tocList = this.bookView.getTableOfContents();

    		if (tocList == null || tocList.isEmpty()) {
    			return;
    		}

    		final CharSequence[] items = new CharSequence[tocList.size()];

    		for (int i = 0; i < items.length; i++) {
    			//items[i] = tocList.get(i).getTitle();
                treeBuilder.sequentiallyAddNextNode((long) i, tocList.get(i).getLevel());
    		}
        } else {
            manager = (TreeStateManager<Long>) savedInstanceState
                    .getSerializable("treeManager");
        }
//        manager.collapseChildren((long) 1);
        setContentView(R.layout.toc_view);
        setTitle(R.string.toc_label);
//       View v = inflater.inflate(R.layout.toc_dialog, container, false);
        treeView = (TreeViewList) findViewById(R.id.toc_view);
        TocAdapter tocAdapter = new TocAdapter(this, manager, LEVEL_NUMBER);
        treeView.setAdapter(tocAdapter);
        treeView.setCollapsible(true);
        
        manager.collapseChildren(null);
//        Util.log_debug_message("@@@@ getIndex = " + this.bookView.getIndex() + " Is in tree " + manager.isInTree((long) this.bookView.getIndex()));
        manager.expandDirectChildren((long) this.bookView.getIndex());
//        registerForContextMenu(treeView);
    }

    protected void pageSelected(int selectedId){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result", TocActivity.tocList.get(selectedId).getHref());
        setResult(RESULT_OK, returnIntent);
        this.finish();
    }
    
    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        outState.putSerializable("treeManager", manager);
        super.onSaveInstanceState(outState);
    }
    
}
