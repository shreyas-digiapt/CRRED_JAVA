package com.vdrop.currd.ui;

import com.vdrop.currd.models.DetailsModel;

import java.util.List;

public interface OnItemClickListner {

    void OnItemClick(int position, List<DetailsModel> mList, String color);
}
