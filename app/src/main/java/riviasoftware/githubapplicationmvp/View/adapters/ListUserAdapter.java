package riviasoftware.githubapplicationmvp.View.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import riviasoftware.githubapplicationmvp.Model.Data.GithubUser;
import riviasoftware.githubapplicationmvp.R;


/**
 * Created by Sergio on 31/03/2017.
 */

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ListUserAdapterViewHolder> implements View.OnClickListener  {

    private Context context;

    private List<GithubUser> data;

    private LayoutInflater inflater;

    private View.OnClickListener listener;


    public ListUserAdapter(Context context, List<GithubUser> data){
            this.context = context;
            this.data = data;
            inflater = LayoutInflater.from(context);
    }

    @Override
    public ListUserAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.user_list,parent,false);
        ListUserAdapterViewHolder holder = new ListUserAdapterViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(ListUserAdapterViewHolder holder, int position) {

        final ImageView image = holder.mImageView;
        Glide.with(context).load(data.get(position).getAvatarUrl()).asBitmap().centerCrop().into(new BitmapImageViewTarget(image) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);

                image.setImageDrawable(circularBitmapDrawable);

            }
        });

        holder.mUserName.setText(data.get(position).getLogin());
        holder.mGithubUrl.setText(data.get(position).getUrl());
        holder.mRetaliveLayout.setTag(data.get(position));
        holder.mRetaliveLayout.setOnClickListener(this);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    // This removes the data from our Dataset and Updates the Recycler View.
    private void removeItem(GithubUser user) {

        int currPosition = data.indexOf(user);
        data.remove(currPosition);
        notifyItemRemoved(currPosition);
    }

    // This method adds(duplicates) a Object (item ) to our Data set as well as Recycler View.
    private void addItem(int position, GithubUser user) {

        data.add(position, user);
        notifyItemInserted(position);
    }

    public void updateMovies(List<GithubUser> users) {
        data = users;
        notifyDataSetChanged();
    }

    public  GithubUser getUser(int adapterPosition) {
        return data.get(adapterPosition);
    }
    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }

    public class ListUserAdapterViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageView;
        TextView mUserName;
        TextView mGithubUrl;
        RelativeLayout mRetaliveLayout;

        public ListUserAdapterViewHolder(View itemView) {
            super(itemView);
            mRetaliveLayout = (RelativeLayout) itemView.findViewById(R.id.relative_user_in_list);
            mImageView = (ImageView) itemView.findViewById(R.id.user_image);
            mUserName = (TextView) itemView.findViewById(R.id.user_name);
            mGithubUrl = (TextView) itemView.findViewById(R.id.github_url);

        }



    }


}
