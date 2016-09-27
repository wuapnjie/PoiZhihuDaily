package com.xiaopo.flying.poizhihudaily.base;

import android.support.v7.util.DiffUtil;

import java.util.List;

/**
 * The Cell Data Diff Callback
 * Created by snowbean on 16-9-11.
 */
public abstract class CellDiffCallback<T extends CellData> extends DiffUtil.Callback {
    protected List<T> mOldCellData;
    protected List<T> mNewCellData;

    public CellDiffCallback(List<T> newCellData) {
        mNewCellData = newCellData;
    }

    public CellDiffCallback(List<T> oldCellData, List<T> newCellData) {
        mOldCellData = oldCellData;
        mNewCellData = newCellData;
    }

    @Override
    public int getOldListSize() {
        return mOldCellData == null ? 0 : mOldCellData.size();
    }

    @Override
    public int getNewListSize() {
        return mNewCellData == null ? 0 : mNewCellData.size();
    }

    @Override
    public abstract boolean areItemsTheSame(int oldItemPosition, int newItemPosition);

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldCellData.get(oldItemPosition)
                .equals(mNewCellData.get(newItemPosition));
    }

    public List<T> getOldCellData() {
        return mOldCellData;
    }

    public void setOldCellData(List<T> oldCellData) {
        mOldCellData = oldCellData;
    }

    public List<T> getNewCellData() {
        return mNewCellData;
    }

    public void setNewCellData(List<T> newCellData) {
        mNewCellData = newCellData;
    }
}
