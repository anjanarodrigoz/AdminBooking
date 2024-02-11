package com.example.adminbooking.Models;

public class BookingDetails {


    private String mName;
    private String mEmail;
    private String mMobileNumber;
    private String mFromAddress;
    private String mToAddress;
    private String mDate;
    private String mTime;
    private String mPrice;
    private String mDeposite;
    private String mTruck;
    private String mTime2;
    private String mNum;
    private String mPack;
    private String mMove;
    private String mNote;
    private String mExtra;
    private String mItem;
    private String orderId;
    private String capacity;
    private String select;
    private String card;
    private String userId;
    private String search;
    private boolean send,edited;


    public BookingDetails() {

    }

    public BookingDetails(String mName, String mEmail, String mMobileNumber, String mFromAddress, String mToAddress, String mDate, String mTime, String mPrice, String mDeposite, String mTruck, String mTime2, String mNum, String mPack, String mMove,
                          String mNote, String mExtra, String mItem, String orderId, String card, String userId, String search, boolean send,boolean edited) {
        this.mName = mName;
        this.mEmail = mEmail;
        this.mMobileNumber = mMobileNumber;
        this.mFromAddress = mFromAddress;
        this.mToAddress = mToAddress;
        this.mDate = mDate;
        this.mTime = mTime;
        this.mPrice = mPrice;
        this.mDeposite = mDeposite;
        this.mTruck = mTruck;
        this.mTime2 = mTime2;
        this.mNum = mNum;
        this.mPack = mPack;
        this.mMove = mMove;
        this.mNote = mNote;
        this.mExtra = mExtra;
        this.mItem = mItem;
        this.orderId = orderId;
        this.card = card;
        this.userId = userId;
        this.search = search;
        this.send = send;
        this.edited = edited;

    }

    public BookingDetails(String mName, String mEmail, String mMobileNumber, String mFromAddress, String mToAddress, String mDate, String mTime, String mPrice, String mDeposite, String mTruck, String mTime2, String mNum, String mPack, String mExtra, String orderId, String capacity, String select) {
        this.mName = mName;
        this.mEmail = mEmail;
        this.mMobileNumber = mMobileNumber;
        this.mFromAddress = mFromAddress;
        this.mToAddress = mToAddress;
        this.mDate = mDate;
        this.mTime = mTime;
        this.mPrice = mPrice;
        this.mDeposite = mDeposite;
        this.mTruck = mTruck;
        this.mTime2 = mTime2;
        this.mNum = mNum;
        this.mPack = mPack;
        this.mExtra = mExtra;
        this.orderId = orderId;
        this.capacity = capacity;
        this.select = select;
    }


    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    public boolean isSend() {
        return send;
    }

    public void setSend(boolean send) {
        this.send = send;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmMobileNumber() {
        return mMobileNumber;
    }

    public void setmMobileNumber(String mMobileNumber) {
        this.mMobileNumber = mMobileNumber;
    }

    public String getmFromAddress() {
        return mFromAddress;
    }

    public void setmFromAddress(String mFromAddress) {
        this.mFromAddress = mFromAddress;
    }

    public String getmToAddress() {
        return mToAddress;
    }

    public void setmToAddress(String mToAddress) {
        this.mToAddress = mToAddress;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public String getmDeposite() {
        return mDeposite;
    }

    public void setmDeposite(String mDeposite) {
        this.mDeposite = mDeposite;
    }

    public String getmTruck() {
        return mTruck;
    }

    public void setmTruck(String mTruck) {
        this.mTruck = mTruck;
    }

    public String getmTime2() {
        return mTime2;
    }

    public void setmTime2(String mTime2) {
        this.mTime2 = mTime2;
    }

    public String getmNum() {
        return mNum;
    }

    public void setmNum(String mNum) {
        this.mNum = mNum;
    }

    public String getmPack() {
        return mPack;
    }

    public void setmPack(String mPack) {
        this.mPack = mPack;
    }

    public String getmMove() {
        return mMove;
    }

    public void setmMove(String mMove) {
        this.mMove = mMove;
    }

    public String getmNote() {
        return mNote;
    }

    public void setmNote(String mNote) {
        this.mNote = mNote;
    }

    public String getmExtra() {
        return mExtra;
    }

    public void setmExtra(String mExtra) {
        this.mExtra = mExtra;
    }

    public String getmItem() {
        return mItem;
    }

    public void setmItem(String mItem) {
        this.mItem = mItem;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
