package com.example.homannh.dsd.dao;

import android.content.Context;

import com.example.homannh.dsd.bll.AdjustmentBLL;
import com.example.homannh.dsd.dto.InvenadjDTO;

import java.util.List;

/**
 * Created by HOH on 2/27/2017.
 */
public interface IInvenadjDAO {
    void initInvenadj(Context context);

    void insert(InvenadjDTO invenadjDTO) throws  Exception;

    void isInvenadjTable();

    int countInvenadj();

    List<InvenadjDTO> getInvenadjByDate(String startDate);
    //Below is to create AdjustmentsBLL
    List<AdjustmentBLL> createInvenadjBLLByDate(String startDate);
}
