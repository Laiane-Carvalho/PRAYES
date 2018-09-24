package testeadapt3.cursoandroid2.com.pray.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import testeadapt3.cursoandroid2.com.pray.R;
import testeadapt3.cursoandroid2.com.pray.fragments.OracoesDiariasFragment;

/**
 * Created by laianeoliveira on 03/09/18.
 */

public class ExpandableAdapter extends BaseExpandableListAdapter {

    private List <String> listGoup;
    private HashMap <String, List <Filho>> listData;
    private LayoutInflater inflater;

    public ExpandableAdapter(Context context, List<String> listGoup, HashMap<String, List<Filho>> listData) {
        this.listGoup = listGoup;
        this.listData = listData;
        inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
    }

    @Override
    public int getGroupCount() {
        return listGoup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listData.get( listGoup.get( groupPosition ) ).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listGoup.get( groupPosition );
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listData.get( listGoup.get( groupPosition ) ).get( childPosition );
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolderGroup holderGroup;

        if (convertView == null) {
            convertView = inflater.inflate( R.layout.header_expandeable_list_view, null );
            holderGroup = new ViewHolderGroup();
            convertView.setTag( holderGroup );

            holderGroup.tvGroup = convertView.findViewById( R.id.tvGroup );

        } else {
            holderGroup = (ViewHolderGroup) convertView.getTag();
        }
        holderGroup.tvGroup.setText( listGoup.get( groupPosition ) );

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderItem holderGroup;

        Filho val = (Filho) getChild( groupPosition, childPosition );

        if (convertView == null) {
            convertView = inflater.inflate( R.layout.item_expandeable_list_view, null );
            holderGroup = new ViewHolderItem();
            convertView.setTag( holderGroup );

            holderGroup.tvItem = convertView.findViewById( R.id.tvItem );

        } else {
            holderGroup = (ViewHolderItem) convertView.getTag();
        }
        holderGroup.tvItem.setText( val.getDescricao() );

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class ViewHolderGroup {
        TextView tvGroup;

    }

    class ViewHolderItem {
        TextView tvItem;

    }

}

