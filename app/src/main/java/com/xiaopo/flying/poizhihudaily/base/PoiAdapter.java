package com.xiaopo.flying.poizhihudaily.base;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by snowbean on 16-9-10.
 */
public abstract class PoiAdapter extends RecyclerView.Adapter {
    private static final String TAG = "PoiAdapter";

    protected List<CellData> mCellData;

    @Override
    public int getItemViewType(int position) {
        return mCellData.get(position).getDataBindingLayout();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return createCell(itemView, viewType);
    }

    protected abstract PoiViewHolder createCell(View itemView, int viewType);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CellData data = mCellData.get(position);

        if (holder == null || data == null) {
            Log.e(TAG, "onBindViewHolder: the holder is null or the data is null");
            return;
        }

        if (holder instanceof PoiViewHolder) {
            ((PoiViewHolder) holder).onBind(data);
        }

    }

    public void swapItems(CellDiffCallback diffCallback) {
        swapItems(diffCallback, false);
    }

    @SuppressWarnings("unchecked")
    public void swapItems(final CellDiffCallback diffCallback, boolean needAsync) {
        if (diffCallback == null) return;
        if (diffCallback.getOldCellData() == null) {
            diffCallback.setOldCellData(mCellData);
        }
        if (needAsync) {
            Observable.just(diffCallback)
                    .map(callback -> DiffUtil.calculateDiff(diffCallback))
                    .subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<DiffUtil.DiffResult>() {
                        private Disposable mDisposable = null;

                        @Override
                        public void onSubscribe(Disposable d) {
                            mDisposable = d;
                        }

                        @Override
                        public void onNext(DiffUtil.DiffResult diffResult) {
                            if (mCellData != null) {
                                mCellData.clear();
                                mCellData.addAll(diffCallback.getNewCellData());
                                diffResult.dispatchUpdatesTo(PoiAdapter.this);
                            } else {
                                refreshData(diffCallback.getNewCellData());
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, "onError: ", e);
                            if (mDisposable != null) {
                                mDisposable.dispose();
                            }
                        }

                        @Override
                        public void onComplete() {
                            if (mDisposable != null) {
                                mDisposable.dispose();
                            }
                        }
                    });
        } else {
            final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

            if (mCellData != null) {
                this.mCellData.clear();
                this.mCellData.addAll(diffCallback.getNewCellData());
                diffResult.dispatchUpdatesTo(this);
            } else {
                refreshData(diffCallback.getNewCellData());
            }
        }

    }

    public void refreshData(List<CellData> data) {
        if (mCellData != null) {
            mCellData.clear();
            mCellData.addAll(data);
        }else {
            mCellData = data;
        }

        notifyDataSetChanged();
    }

    public void addData(List<CellData> data) {
        if (data == null) return;
        if (mCellData == null) {
            refreshData(data);
            return;
        }
        final int oldCount = getItemCount();
        mCellData.addAll(data);

        notifyItemInserted(oldCount);
    }

    @Override
    public int getItemCount() {
        return mCellData == null ? 0 : mCellData.size();
    }


    public List<CellData> getCellData() {
        return mCellData;
    }
}
