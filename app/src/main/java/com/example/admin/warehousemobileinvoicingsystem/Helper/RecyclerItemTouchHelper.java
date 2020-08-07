package com.example.admin.warehousemobileinvoicingsystem.Helper;

import android.graphics.Canvas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback;

import android.view.View;

import com.example.admin.warehousemobileinvoicingsystem.Customers.CustomAdapter_rv_custneworder;

public class RecyclerItemTouchHelper extends SimpleCallback {

  private RecyclerItemTouchHelperListner listner;
  private boolean swipeBack;


  public RecyclerItemTouchHelper(int dragDirs, int swipeDirs, RecyclerItemTouchHelperListner listner) {
    super(dragDirs, swipeDirs);
    this.listner = listner;
  }

  @Override
  public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
    return true;
  }

  @Override
  public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    if (listner != null) {
      listner.onSwiped(viewHolder, i, viewHolder.getAdapterPosition());
    }

  }

  @Override
  public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
    View forgroundview = ((CustomAdapter_rv_custneworder.MyViewHolder) viewHolder).itemView;
    getDefaultUIUtil().clearView(forgroundview);
  }

  @Override
  public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {


    View forgroundview = ((CustomAdapter_rv_custneworder.MyViewHolder) viewHolder).itemView;
    getDefaultUIUtil().onDraw(c, recyclerView, forgroundview, dX, dY, actionState, isCurrentlyActive);

  }

  @Override
  public void onChildDrawOver(@NonNull Canvas c, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

    View forgroundview = ((CustomAdapter_rv_custneworder.MyViewHolder) viewHolder).itemView;
    getDefaultUIUtil().onDrawOver(c, recyclerView, forgroundview, dX, dY, actionState, isCurrentlyActive);

  }

  @Override
  public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
    if (viewHolder != null) {
      View forgroundview = ((CustomAdapter_rv_custneworder.MyViewHolder) viewHolder).itemView;
      getDefaultUIUtil().onSelected(forgroundview);
    }
  }

  @Override
  public int convertToAbsoluteDirection(int flags, int layoutDirection) {
    if (swipeBack) {
      swipeBack = false;
      return 0;
    }
    return super.convertToAbsoluteDirection(flags, layoutDirection);
  }
}
