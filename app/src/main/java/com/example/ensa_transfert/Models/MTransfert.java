package com.example.ensa_transfert.Models;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.O)
public class MTransfert {

    private LocalDateTime createdAt = LocalDateTime .now();
    private LocalDateTime  endedAt = createdAt.plusDays(4); //

    private Integer id_client=0;

    private double totalAmount;

    private String motif; // motif for all transfers within this multi transfer

    private double total_expense_amount;

    private String senderFirstName;


    private String senderLastName;

    private String senderPhoneNumber;


    private boolean prospect_client;

    private Integer sentByAgentWithId;

    private boolean transferByCash;

    //private int expense_id;  // ???

    private boolean notifyBeneficiary;

    private List<Transfert> transfers;
}

