package riviasoftware.githubapplicationmvp.ui.view.adapters;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
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

import java.util.List;

import riviasoftware.githubapplicationmvp.BR;
import riviasoftware.githubapplicationmvp.databinding.UserListBinding;
import riviasoftware.githubapplicationmvp.model.GithubUser;
import riviasoftware.githubapplicationmvp.R;
import riviasoftware.githubapplicationmvp.ui.presenters.MainFragmentPresenter;
import riviasoftware.githubapplicationmvp.ui.presenters.Presenter;

import static com.bumptech.glide.request.RequestOptions.circleCropTransform;


/**
 * Created by Sergio on 31/03/2017.
 */

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ListUserAdapterViewHolder> implements View.OnClickListener  {

    private Context context;

    private List<GithubUser> data;

    private LayoutInflater inflater;

    private View.OnClickListener listener;

    private UserListBinding binding;

    private MainFragmentPresenter presenter;

    public ListUserAdapter(Context context, List<GithubUser> data, MainFragmentPresenter presenter){
            this.context = context;
            this.data = data;
            this.presenter = presenter;
            inflater = LayoutInflater.from(context);
    }

    @Override
    public ListUserAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        binding = DataBindingUtil.inflate(inflater,R.layout.user_list,parent,false);
        return new ListUserAdapterViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(ListUserAdapterViewHolder holder, int position) {
        final GithubUser user = data.get(position);
        holder.bind(user,presenter);
    }

    @BindingAdapter("android:src")
    public static void setImageUrl(ImageView view, String url) {
        Glide.with(view.getContext()).load(url)
                .apply(circleCropTransform()).into(view);
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

        private ViewDataBinding binding;

        public ListUserAdapterViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        public void bind (GithubUser user, MainFragmentPresenter p){
            binding.setVariable(BR.user, user);
            binding.setVariable(BR.presenter,p);
            binding.executePendingBindings();
        }





    }


}
