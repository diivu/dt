package com.triapp.SqliteDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager extends SQLiteOpenHelper {

    private static com.triapp.SqliteDatabase.DatabaseManager sInstance = null;

    public static synchronized com.triapp.SqliteDatabase.DatabaseManager getInstance(Context context,
                                                                                     String name, SQLiteDatabase.CursorFactory factory, int version) {

        if (sInstance == null) {
            sInstance = new com.triapp.SqliteDatabase.DatabaseManager(context.getApplicationContext(),
                    name, factory, version);
        }
        return sInstance;
    }

    public DatabaseManager(Context context, String name, SQLiteDatabase.CursorFactory factory,
                           int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        //INSERT STATE LIST FROM BASIC API
        db.execSQL(state());

        //INSERT DISTRINCT LIST FROM BASIC API
        db.execSQL(distrinct());

        //INSERT BLOCK LIST FROM BASIC API
        db.execSQL(block());

        //INSERT VILLAGE LIST FROM BASIC API
        db.execSQL(villege());

        //INSERT GRAM PUNCHAYAT LIST FROM BASIC API
        db.execSQL(grampanchayat());

        //INSERT RELIGION LIST FROM BASIC API
        db.execSQL(religionList());

        //INSERT CAST LIST FROM BASIC API
        db.execSQL(castList());

        //INSERT ENTERPRENEUR LIST FROM APP WHICH WE WILL SYNC IT TO WEB
        db.execSQL(createEnterpreneur());

        //INSERT ENTERPRENEUR EDUCATION DETAILS
        db.execSQL(entrepreneurEducationQualificationlist());

        //INSERT ENTERPRENEUR SPECIAL TRAINING DETAILS
        db.execSQL(entrepreneurSpecialTraininglist());

        //INSERT ENTERPRENEUR WORK EXPERIENCE DETAILS
        db.execSQL(entrepreneurWorkExperiencelist());

        //INSERT ENTERPRENEUR EDUCATION, SPECIAL TRAINING AND WORK EXPERIENCE DATA WHICH WE WILL USE IT TO SYNC WITH WEB
        db.execSQL(entrepreneurEduJobProfile());

        //INSERT ENTERPRENEUR TRAINING DETAILS
        db.execSQL(createTableTrainigDetails());

        //GROWTH PLAN PUPOSE LIST
        db.execSQL(newGrowthPlanpurposeList());

        //EXPENDITURE DETAILS
        db.execSQL(entrepreneurExpenditure());

        //EXPENDITURE DETAILS FOR ENTERPRENEUR
        db.execSQL(entrepreneurFamilyExpenditureslist());

        //CREATE ENTERPRENEUR INCOME PROFILE
        db.execSQL(createTableEnterpreneurIncomeDetails());

        //CREATE BUSINESS PLAN STEP-1 TABLE
        db.execSQL(entrepreneurBusinessplanStepOne());

        //CREATE BUSINESS PLAN STEP-2.0 TABLE
        db.execSQL(bsinessPlanStep2_0());

        //CREATE BUSINESS PLAN STEP-2.1 TABLE
        db.execSQL(entrepreneurBusinessplanStep2_1());

        //CREATE BUSINESS PLAN STEP-3.0 TABLE
        db.execSQL(entrepreneurBusinessplanStep3of0());

        //CREATE BUSINESS PLAN STEP-3.1 TABLE
        db.execSQL(entrepreneurBusinessplanStep3of1());

        //CREATE BUSINESS PLAN STEP-3.2 TABLE
        db.execSQL(entrepreneurBusinessplanStep3of2());

        //CREATE BUSINESS PLAN STEP-3.3 TABLE
        db.execSQL(entrepreneurBusinessplanStep3of3());

        //CREATE BUSINESS PLAN STEP-3.4 TABLE
        db.execSQL(entrepreneurBusinessplanStep3of4());

        //CREATE BUSINESS PLAN STEP-3.5 TABLE
        db.execSQL(entrepreneurBusinessplanStep3of5());

        //CREATE BUSINESS PLAN STEP-3.6 TABLE
        db.execSQL(entrepreneurBusinessplanStep3of6());

        //CREATE BUSINESS PLAN STEP-3.7 TABLE
        db.execSQL(entrepreneurBusinessplanStep3of7());

        //CREATE BUSINESS PLAN STEP-3.8 TABLE
        db.execSQL(entrepreneurBusinessplanStep3of8());

        //CREATE BUSINESS PLAN STEP-3.9 TABLE
        db.execSQL(entrepreneurBusinessplanStep3of9());

        //CREATE BUSINESS PLAN STEP-3.10 TABLE
        db.execSQL(entrepreneurBusinessplanStep3of10());

        //CREATE BUSINESS PLAN STEP-3.10 TABLE
        db.execSQL(entrepreneurBusinessplanStep4of0());

        //CREATE CAMPAIGN DATA
        db.execSQL(createCampaignData());

        //CREATE MEMBER DATA
        db.execSQL(createEventMemberData());

        //CREATE ENTERPRISE REGISTRATION TABLE
        db.execSQL(createEnterpriseRegistrationTable());

        //CREATE ENTERPRISE TRACKING TABLE
        db.execSQL(createEnterpriseTrackingTable());

    }




    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        throw new SQLiteException("Can't downgrade database from version " +
                oldVersion + " to " + newVersion);
        //super.onDowngrade(db, oldVersion, newVersion);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    private String state() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_STATES
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_STATE_NAME + " text, "
                + DatabaseHelper.KEY_STATE_ID + " Long, "
                + DatabaseHelper.KEY_STATE_CODE + " text);";
    }

    private String distrinct() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_DISTRICT
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_DISTRICT_ID + " Long, "
                + DatabaseHelper.KEY_DISTRICT_NAME + " text, "
                + DatabaseHelper.KEY_DISTRICT_STATE_ID + " integer);";

    }

    private String block() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_BLOCK
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_BLOCK_ID + " Long, "
                + DatabaseHelper.KEY_BLOCK_NAME + " text, "
                + DatabaseHelper.KEY_BLOCK_DISTRICT_ID + " integer);";

    }


    private String villege() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_VILLAGE
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_VILLAGE_ID + " Long, "
                + DatabaseHelper.KEY_VILLAGE_NAME + " text, "
                + DatabaseHelper.KEY_VILLAGE_BLOCK_CODE + " integer);";
    }

    private String grampanchayat() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_GRAMPANCHAYAT
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_GRAMPANCHAYAT_ID + " Long, "
                + DatabaseHelper.KEY_GRAMPANCHAYAT_NAME + " text, "
                + DatabaseHelper.KEY_GRAMPANCHAYAT_CODE + " integer);";
    }

    private String religionList() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_RELIGION_LIST
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_RILIGION_ID + " integer, "
                + DatabaseHelper.KEY_RILIGION_NAME + " text);";
    }

    private String castList() {
        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_CAST_LIST
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_CAST_ID + " integer, "
                + DatabaseHelper.KEY_CAST_NAME + " text);";
    }

    private String createEnterpreneur() {
        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_CREATE_ENTERPRENEUR
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_ID + " Long, "
                + DatabaseHelper.KEY_USER_ID + " Long, "
                + DatabaseHelper.KEY_LATITUDE + " double, "
                + DatabaseHelper.KEY_LONGITUDE + " double, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_ENTERPRISE_TYPE + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_ENTERPRISE_NAME + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_TYPE_OF_ENTERPRISE + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_DESCRIPTION + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_FIRSTNAME + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_MIDDLENAME + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_LASTNAME + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_BIRTHDATE + " Long, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_GENDER + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_EMAILID + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_SOCIAL_CATEGORY + " Long, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_STATE + " Long, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_DISTRICT + " Long, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_BLOCK + " Long, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_VILLEGE + " Long, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_RESIDENCE_ADDRESS + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_PINCODE + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_ADDHAR_NO + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_PAN_NO + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_BANK_ACCOUNT_NO + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_BANK_NAME + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_BRANCH_NAME + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_BANK_IFSC + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_MARITAL_STATUS + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_CREATED + " integer, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_SUBMITTED + " integer, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_IS_MODEL + " integer, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_IS_ENTERPRISE_REGISTRED + " integer, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_FULL_NAME + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_ENROLLMENT_DATE + " Long, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_NO_OF_DEPENDENT + " integer, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_IS_JOIN_EVENT + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_EVENT_NAME + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRENEUR_PARICIPANT_NAME + " text);";
    }

    private String entrepreneurEducationQualificationlist() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENUR_EDUCATION_QUALIFICATION_LIST
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_CREATED_BY_GET + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_MODIFIED_BY_GET + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_CREATED_DATE_GET + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_ID_GET + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_QUALIFICATION_NAME_GET + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_UNIVERSITY_NAME_GET + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_PASSING_YEAR_GET + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_MAJOR_SUBJECT_GET + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_ENTREPRENEUR_ID_GET + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_DELETED_GET + " integer);";
    }

    private String entrepreneurSpecialTraininglist() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENUR_SPECIAL_TRAINING_LIST
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_ID_GET + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_SUBJECT_GET + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_INSTITUTE_GET + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_DURATION_GET + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_LEARNING_GET + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_RNTREPRENEUR_ID_GET + " Long);";
    }

    private String entrepreneurWorkExperiencelist() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENUR_WORK_EXPERIENCE_LIST
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_ID_GET + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_ORGANISATION_GET + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_DESIGNATION_GET + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_JOB_PROFILE_GET + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_DURATION_GET + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_ENTREPRENEUR_ID_GET + " Long);";
    }

    private String entrepreneurEduJobProfile() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENEUR_EDU_JOB_DETAILS
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_ENTREPRENEUR_EDU_JOB_ENTREPRENEUR_ID + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EDU_JOB_EDUCATION + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EDU_JOB_SPECIAL_TRAINING + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EDU_JOB_EORK_EXPERIENCE + " text );";
    }

    private String createTableTrainigDetails() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENEUR_TRAINING
                + " ( " + DatabaseHelper.KEY_ENTREPRENEUR_TRAINING_ID_PK + " Long PRIMARY KEY,"
                + DatabaseHelper.KEY_ENTREPRENEUR_TRAINING_ENTREPRENEUR_ID + " Long,"
                + DatabaseHelper.KEY_ENTREPRENEUR_TRAINING_NAME + " text,"
                + DatabaseHelper.KEY_ENTREPRENEUR_TRAINING_START_DATE + " Long,"
                + DatabaseHelper.KEY_ENTREPRENEUR_TRAINING_END_DATE + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_TRAINING_DESCRIPTION + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_TRAINING_LATITUDE + " Double, "
                + DatabaseHelper.KEY_ENTREPRENEUR_TRAINING_LONGITUDE + " Double, "
                + DatabaseHelper.KEY_ENTREPRENEUR_TRAINING_CREATED_BY + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_TRAINING_CREATED_DATE + " Long  );";
    }

    private String newGrowthPlanpurposeList() {
        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_NEW_GROWTH_PURPOSE_LIST
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_NEW_GROWTH_PLAN_PURPOSE_ID + " Long, "
                + DatabaseHelper.KEY_NEW_GROWTH_PLAN_PURPOSE_VALUE + " text );";
    }

    private String entrepreneurExpenditure() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENEUR_EXPENDITURE
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_ENTREPRENEUR_EXPENDITURE + " text );";
    }


    private String entrepreneurFamilyExpenditureslist() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENUR_EXPENDITURES_LIST
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_CREATED_BY_GET + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_MODIFIED_BY_GET + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_CREATED_DATE_GET + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ID_GET + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ITEM_TYPE_GET + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_MONTHLY_EXPENSE_GET + " Double, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ANNUAL_EXPENSE_GET + " Double, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ENTREPRENEUR_ID_GET + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ITEM_TYPE_ID_GET + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_LONGITUDE_GET + " Double, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_LATITUDE_GET + " Double, "
                + DatabaseHelper.KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_DELETED_GET + " integer);";

    }

    private String createTableEnterpreneurIncomeDetails() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENUR_INCOME_PROFILE
                + " ( " + DatabaseHelper.KEY_ID + " Long PRIMARY KEY,"
                + DatabaseHelper.KEY_ENTERPRENEUR_ID + " Long,"
                + DatabaseHelper.KEY_LATITUDE + " Double,"
                + DatabaseHelper.KEY_LONGITUDE + " Double,"
                + DatabaseHelper.KEY_ENTREPRENEUR_INCOME_ANNUAL_INCOME + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_INCOME_ANNUAL_INCOME_ID + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_INCOME_SELF_INCOME + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_INCOME_SELF_INCOME_ID + " Long, "
                + DatabaseHelper.KEY_CREATED_BY + " Long, "
                + DatabaseHelper.KEY_CREATED_DATE + " Long);";
    }

    private String entrepreneurBusinessplanStepOne() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENEUR_BUSINESSPLAN_1_0_CREATE
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_NAME_OF_UNIT + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_ADDRESS_OF_UNIT + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_ENTREPRENEUR_ID + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_BP_ID + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_NATURE_OF_ID + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_IS_GOVT_LICENCE + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_PINCODE + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_STATE_ID + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_DISTRICT_ID + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_BLOCK_ID + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_VILLAGE_ID + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_LICENCE_DATE + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_LICENCE_REG_NO + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_TYPE_NO + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_SECTOR_NO + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_CREATED_DATE + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_BP_FLAG + " integer, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_BP_SYNC_STATUS + " integer, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_IS_MODEL_BUSINESS_PLAN + " integer, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_IS_BUSINESS_PLAN_SUBMITE + " integer);";

    }

    private String bsinessPlanStep2_0() {
        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_NEW_BUSINESS_PLAN_DATA
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_ITEM_ID + " Long, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_ID + " Long, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_20_PRODUCT_NAME + " String, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_20_WORKING_UNITES + " String, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_20_ENTER_WORKING_UNITES + " String, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_20_PER_DAY_EIGHT_HOURS + " double, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_PRODUCTION + " double, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_20_PER_DAY_SIXTY_PERCENT + " double, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_UTILIZATION + " double, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_20_SALE_PRICE_PER_UNIT + " double, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_20_AMOUNT + " double, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_20_SALE_IN_PERCENTAGE + " integer, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_20_IS_FIELD_EDITBLE + " integer, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_20_COST_PRICE + " double, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_COST_PRICE + " double);";
    }

    private String entrepreneurBusinessplanStep2_1() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENEUR_BUSINESSPLAN_2_1_CREATE
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_PRODUCT + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_AMOUNT + " Double, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_BUSINESSPLAN_ID + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_ENTREPRENEUR_ID + " Long );";
    }

    private String entrepreneurBusinessplanStep3of0() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENEUR_BUSINESSPLAN_3_0_CREATE
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_0_LIST_OF_PREOPERATIVES + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_0_BUSINESSPLAN_ID + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_0_ENTREPRENEUR_ID + " Long );";
    }

    private String entrepreneurBusinessplanStep3of1() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENEUR_BUSINESSPLAN_3_1_CREATE
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_1_LIST_OF_LAND_BUILDINGS + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_1_BUSINESSPLAN_ID + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_1_ENTREPRENEUR_ID + " Long );";
    }

    private String entrepreneurBusinessplanStep3of2() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENEUR_BUSINESSPLAN_3_2_CREATE
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_2_ITEM_ID + " Long, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_2_BUSINESS_PLAN_ID + " Long, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_2_PERTICULER + " String, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_2_NO + " Long, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_2_PRICE + " double, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_2_AMOUNT + " double, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_2_PURCHASE_DATE + " Long, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_2_EXPECTED_LIFE + " Long, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_2_SCRAP_VALUE + " Long, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_2_DEPRICIATION + " double, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_2_BOOK_VALUE + " double, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_2_SUPPLIERS_ADDRESS + " String, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_2_TAX_TRANSPORTATION + " double, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_2_ELECTRIFICATION + " double, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_2_UPLOAD_QUOTATION + " String, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_2_IS_FIELD_EDITABLE + " integer);";
    }

    private String entrepreneurBusinessplanStep3of3() {
        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENEUR_BUSINESSPLAN_3_3_CREATE
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_3_ITEM_ID + " Long, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_3_BUSINESS_PLAN_ID + " Long, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_3_PERTICULER + " String, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_3_NO + " Long, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_3_PRICE + " double, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_3_AMOUNT + " double, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_3_PURCHASE_DATE + " Long, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_3_EXPECTED_LIFE + " Long, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_3_SCRAP_VALUE + " Long, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_3_DEPRICIATION + " double, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_3_BOOK_VALUE + " double, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_3_SUPPLIERS_ADDRESS + " String, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_3_UPLOAD_QUPTATIONS + " String, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_3_IS_FIELD_EDITABLE + " integer);";
    }

    private String entrepreneurBusinessplanStep3of4() {
        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENEUR_BUSINESSPLAN_3_4_CREATE
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEM_ID + " Long, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_4_BUSINESS_PLAN_ID + " Long, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEMS + " String, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_4_FOR_MONTHS + " integer, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_4_QUANTITY_PER_UNIT + " double, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_4_UNIT_RATE + " double, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_4_TOTAL_RATE + " double, "
                + DatabaseHelper.KEY_NEW_BUSINESS_PLAN_STEP_3_4_IS_FIELD_EDITABLE + " integer);";
    }

    private String entrepreneurBusinessplanStep3of5() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENEUR_BUSINESSPLAN_3_5_CREATE
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_5_LIST_OF_UTILITIES + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_5_BUSINESSPLAN_ID + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_5_ENTREPRENEUR_ID + " Long );";
    }

    private String entrepreneurBusinessplanStep3of6() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENEUR_BUSINESSPLAN_3_6_CREATE
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_6_LIST_OF_MANPOWERS + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_6_BUSINESSPLAN_ID + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_6_ENTREPRENEUR_ID + " Long );";
    }

    private String entrepreneurBusinessplanStep3of7() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENEUR_BUSINESSPLAN_3_7_CREATE
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_7_LIST_OF_ADMINISTRATIVES + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_7_BUSINESSPLAN_ID + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_7_ENTREPRENEUR_ID + " Long );";
    }

    private String entrepreneurBusinessplanStep3of8() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENEUR_BUSINESSPLAN_3_8_CREATE
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_8_LIST_OF_SELLING + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_8_BUSINESSPLAN_ID + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_8_ENTREPRENEUR_ID + " Long );";
    }

    private String entrepreneurBusinessplanStep3of9() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENEUR_BUSINESSPLAN_3_9_CREATE
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_9_LIST_OF_WORKING_CAPITALS + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_9_BUSINESSPLAN_ID + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_9_ENTREPRENEUR_ID + " Long );";
    }

    private String entrepreneurBusinessplanStep3of10() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENEUR_BUSINESSPLAN_3_10_CREATE
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_10_TOTAL_COST_ODF_PROJECT + " Double, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_10_BUSINESSPLAN_ID + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_3_10_ENTREPRENEUR_ID + " Long );";
    }
    private String entrepreneurBusinessplanStep4of0() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_ENTREPRENEUR_BUSINESSPLAN_4_0_CREATE
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_4_0_LIST_OF_MEANS_OF_FINANCE + " text, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_4_0_BUSINESSPLAN_ID + " Long, "
                + DatabaseHelper.KEY_ENTREPRENEUR_BUSINESSPLAN_4_0_ENTREPRENEUR_ID + " Long );";
    }

    private String createCampaignData() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_CREATE_CAMPAIGN
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_CREATE_CAMPAIGN_ID + " Long, "
                + DatabaseHelper.KEY_CREATE_CAMPAIGN_NAME + " text, "
                + DatabaseHelper.KEY_CREATE_CAMPAIGN_DATE + " Long, "
                + DatabaseHelper.KEY_CREATE_CAMPAIGN_ADDRESS + " text, "
                + DatabaseHelper.KEY_CREATE_CAMPAIGN_MORE_INFO + " text, "
                + DatabaseHelper.KEY_CREATE_CAMPAIGN_MOBILE_USER_ID + " Long, "
                + DatabaseHelper.KEY_LATITUDE + " double, "
                + DatabaseHelper.KEY_LONGITUDE + " double );";
    }

    private String createEventMemberData() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_CREATE_EVENT_MEMBER_TABLE
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_CREATE_MEMBER_NAME + " text, "
                + DatabaseHelper.KEY_CREATE_MEMBER_BIRTH_DATE + " Long, "
                + DatabaseHelper.KEY_CREATE_MEMBER_PHONE_NUMBER + " text, "
                + DatabaseHelper.KEY_CREATE_MEMBER_ID + " Long, "
                + DatabaseHelper.KEY_CREATE_MEMBER_MOBILE_USER_NAME_ID + " Long, "
                + DatabaseHelper.KEY_LATITUDE + " double, "
                + DatabaseHelper.KEY_LONGITUDE + " double, "
                + DatabaseHelper.KEY_CREATE_MEMBER_CREAETED_DATE + " Long, "
                + DatabaseHelper.KEY_CREATE_MEMBER_EVENT_ID + " Long );";
    }

    private String createEnterpriseRegistrationTable() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_CREATE_ENTERPRISE_REGISTRATION
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRENEUR_NAME + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRISE_NAME + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRENEUR_ID + " Long, "
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRISE_ID + " Long, "
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_REGISTRATION_BLOCK_ID + " Long, "
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_REGISTRATION_VILLAGE_ID + " Long, "
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_REGISTRATION_STARTING_DATE + " Long, "
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_REGISTRATION_IMAGE_URL + " Long, "
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_REGISTRATION_CREATED_DATE + " Long, "
                + DatabaseHelper.KEY_LATITUDE + " double, "
                + DatabaseHelper.KEY_LONGITUDE + " double );";
    }

    private String createEnterpriseTrackingTable() {

        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_CREATE_ENTERPRISE_TRACKING
                + " ( " + DatabaseHelper.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_TRACKING_ENTERPRISE_NAME + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_TRACKING_ENTERPRISE_ID + " Long, "
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_TRACKING_ENTERPRENEURE_ID + " Long, "
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_TRACKING_MOBILE_USER_ID + " Long, "
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_TRACKING_STATUS + " text, "
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_TRACKING_TURNOVER + " double, "
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_TRACKING_PROFITES + " double, "
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_TRACKING_PEAPOLE_EMPLOYED + " integer, "
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_TRACKING_CAPITAL_DEPLOY + " double, "
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_TRACKING_RETURN_ON_INVESTMENT + " double, "
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_TRACKING_PROFITE_AS_PERCENTAGE + " double, "
                + DatabaseHelper.KEY_CREATE_ENTERPRISE_TRACKING_CURRENT_TIME + " Long, "
                + DatabaseHelper.KEY_LATITUDE + " double, "
                + DatabaseHelper.KEY_LONGITUDE + " double );";
    }

}

