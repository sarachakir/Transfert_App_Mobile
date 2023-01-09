package com.example.ensa_transfert.Models;

import com.example.ensa_transfert.Models.Enumerators.TransferStatus;
import com.example.ensa_transfert.Models.Enumerators.TransfertType;

import java.time.LocalDateTime;

public class Transfert {

    private LocalDateTime receivedAt; // when the beneficiary receive their money we fill this attribute
    private String transferReference;
    private String codePin;

    private double transferAmount;
    private double transferCost;

    private double finalAmountOperation ;

    private double finalAmountTransfer ;

    private boolean toBeNotified;

    private TransferStatus status;

    private TransfertType type;
    //private String motif;

    private String receiverFirstName; // beneficiary first  name

    private String receiverLastName; // beneficiary  last name

    private String receiverPhoneNumber; // beneficiary phone number

    private MTransfert mTransfer;

}
