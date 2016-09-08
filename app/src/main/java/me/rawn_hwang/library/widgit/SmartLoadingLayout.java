package me.rawn_hwang.library.widgit;

import android.app.Activity;
import android.view.View;

public class SmartLoadingLayout {
    private View mLoadingView;
    private View mContentView;
    private View mEmptyView;
    private View mErrorView;
    private Activity mHostActivity;


    public SmartLoadingLayout(Activity activity) {
        mHostActivity = activity;
    }

    public void setLoadingView(int viewID) {
        mLoadingView = mHostActivity.findViewById(viewID);
    }

    public void setContentView(int viewID) {
        mContentView = mHostActivity.findViewById(viewID);
    }

    public void setEmptyView(int viewID) {
        mEmptyView = mHostActivity.findViewById(viewID);
    }

    public void setErrorView(int viewID) {
        mErrorView = mHostActivity.findViewById(viewID);
    }

    public void onLoading() {
        showViewWithStatus(LayoutStatus.Loading);
    }

    public void onDone() {
        showViewWithStatus(LayoutStatus.Done);
    }

    public void onEmpty() {
        showViewWithStatus(LayoutStatus.Empty);
    }

    public void onError() {
        showViewWithStatus(LayoutStatus.Error);
    }

    private void showViewWithStatus(LayoutStatus status) {
        switch (status) {
            case Loading:
                if (mLoadingView == null) {
                    throw new NullPointerException("The loading view with this layout was not set");
                }
                mLoadingView.setVisibility(View.VISIBLE);
                if (mContentView != null)
                    mContentView.setVisibility(View.GONE);
                if (mEmptyView != null)
                    mEmptyView.setVisibility(View.GONE);
                if (mErrorView != null)
                    mErrorView.setVisibility(View.GONE);
                break;
            case Done:
                if (mContentView == null) {
                    throw new NullPointerException("The loading view with this layout was not set");
                }
                mContentView.setVisibility(View.VISIBLE);
                if (mLoadingView != null)
                    mLoadingView.setVisibility(View.GONE);
                if (mEmptyView != null)
                    mEmptyView.setVisibility(View.GONE);
                if (mErrorView != null)
                    mErrorView.setVisibility(View.GONE);
                break;
            case Empty:
                if (mEmptyView == null) {
                    throw new NullPointerException("The loading view with this layout was not set");
                }
                mEmptyView.setVisibility(View.VISIBLE);
                if (mLoadingView != null)
                    mLoadingView.setVisibility(View.GONE);
                if (mContentView != null)
                    mContentView.setVisibility(View.GONE);
                if (mErrorView != null)
                    mErrorView.setVisibility(View.GONE);
                break;
            case Error:
                if (mErrorView == null) {
                    throw new NullPointerException("The loading view with this layout was not set");
                }
                mErrorView.setVisibility(View.VISIBLE);
                if (mLoadingView != null)
                    mLoadingView.setVisibility(View.GONE);
                if (mContentView != null)
                    mContentView.setVisibility(View.GONE);
                if (mEmptyView != null)
                    mEmptyView.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }


    private enum LayoutStatus {
        Loading, Done, Empty, Error
    }
}
