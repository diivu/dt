package com.triapp.SqliteDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.triapp.CommonClasse.CommonMethods;
import com.triapp.Models.AdministrativeModel;
import com.triapp.Models.BlockListModel;
import com.triapp.Models.CampaignDataModel;
import com.triapp.Models.CastListModel;
import com.triapp.Models.CreateEnterpreneurModel;
import com.triapp.Models.DistrinctListModel;
import com.triapp.Models.EducationJobProfileDTO;
import com.triapp.Models.EducationQualificationModel;
import com.triapp.Models.EnterpreneurIncomeProfileModel;
import com.triapp.Models.EnterpreneurTrainingDetailsModel;
import com.triapp.Models.EnterpriseRegistrationModel;
import com.triapp.Models.EnterpriseTrackingData;
import com.triapp.Models.EntrepreneurListModel;
import com.triapp.Models.EventMemberModel;
import com.triapp.Models.ExpanditureModel;
import com.triapp.Models.GetNewBusinessPlanDataModel;
import com.triapp.Models.GrowthPlanGrowthPurposeListModel;
import com.triapp.Models.LandBuildingModel;
import com.triapp.Models.ManPowerModel;
import com.triapp.Models.MeansOfFinanceModel;
import com.triapp.Models.NewBusinessPlanFurnitureStep3_3Model;
import com.triapp.Models.ParticularsEditedAnswerModel;
import com.triapp.Models.PlantAndMachineryAddMorNeweModel;
import com.triapp.Models.ProductionAndRevenueDetailModel;
import com.triapp.Models.RawMaterialModel;
import com.triapp.Models.ReligionListModel;
import com.triapp.Models.SalesRealisationModel;
import com.triapp.Models.SaveEnterpriseModel;
import com.triapp.Models.SelectedParticularsModel;
import com.triapp.Models.SellingDistributionExpensModel;
import com.triapp.Models.SpecialTrainingModel;
import com.triapp.Models.StateListModel;
import com.triapp.Models.SubmitLandBuildingData;
import com.triapp.Models.TotalProjectCostModel;
import com.triapp.Models.UserBasicDetailsModel;
import com.triapp.Models.UtilitiesModel;
import com.triapp.Models.VillegeListModel;
import com.triapp.Models.WorkExperienceDTOModel;
import com.triapp.Models.WorkExperienceModel;
import com.triapp.Models.WorkingCapitalModel;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DatabaseHelper {

    public static final String DATABASE_NAME = "tata_tri.db";
    public static final int DATABASE_VERSION = 1;

    //Table names
    public static String TABLE_STATES = "listState";
    public static String TABLE_DISTRICT = "listDistrict";
    public static String TABLE_BLOCK = "listBlock";
    public static String TABLE_VILLAGE = "listVillage";
    public static String TABLE_GRAMPANCHAYAT = "listGrampanchayat";
    public static String TABLE_RELIGION_LIST = "listReligion";
    public static String TABLE_CAST_LIST = "listCast";
    public static String TABLE_CREATE_ENTERPRENEUR = "tableCreateEnterpreneur";
    public static String TABLE_ENTREPRENUR_EDUCATION_QUALIFICATION_LIST = "listEntrepreneurEducationQualification";
    public static String TABLE_ENTREPRENUR_SPECIAL_TRAINING_LIST = "listEntrepreneurSpecialTraing";
    public static String TABLE_ENTREPRENUR_WORK_EXPERIENCE_LIST = "listEntrepreneurWorkExperienceTraing";
    public static String TABLE_ENTREPRENEUR_EDU_JOB_DETAILS = "entrepreneurEduJobDetails";
    public static String TABLE_ENTREPRENEUR_TRAINING = "entrepreneurSvepTrainingDetail";
    public static String TABLE_NEW_GROWTH_PURPOSE_LIST = "newGrowthPurposeList";
    public static String TABLE_ENTREPRENEUR_EXPENDITURE = "entrepreneurExpenditure";
    public static String TABLE_ENTREPRENUR_EXPENDITURES_LIST = "listEntrepreneurExpenditures";
    public static String TABLE_ENTREPRENUR_INCOME_PROFILE = "listEntrepreneurIncomeProfile";
    public static String TABLE_ENTREPRENEUR_BUSINESSPLAN_1_0_CREATE = "entrepreneurBusinessplan10Create";
    public static String TABLE_NEW_BUSINESS_PLAN_DATA = "newBusinessPlan";
    public static String TABLE_ENTREPRENEUR_BUSINESSPLAN_2_1_CREATE = "entrepreneurBusinessplan21Create";
    public static String TABLE_ENTREPRENEUR_BUSINESSPLAN_3_0_CREATE = "entrepreneurBusinessplan30Create";
    public static String TABLE_ENTREPRENEUR_BUSINESSPLAN_3_1_CREATE = "entrepreneurBusinessplan31Create";
    public static String TABLE_ENTREPRENEUR_BUSINESSPLAN_3_2_CREATE = "entrepreneurBusinessplan32Create";
    public static String TABLE_ENTREPRENEUR_BUSINESSPLAN_3_3_CREATE = "entrepreneurBusinessplan33Create";
    public static String TABLE_ENTREPRENEUR_BUSINESSPLAN_3_4_CREATE = "entrepreneurBusinessPlan34Create";
    public static String TABLE_ENTREPRENEUR_BUSINESSPLAN_3_5_CREATE = "entrepreneurBusinessplan35Create";
    public static String TABLE_ENTREPRENEUR_BUSINESSPLAN_3_6_CREATE = "entrepreneurBusinessplan36Create";
    public static String TABLE_ENTREPRENEUR_BUSINESSPLAN_3_7_CREATE = "entrepreneurBusinessplan37Create";
    public static String TABLE_ENTREPRENEUR_BUSINESSPLAN_3_8_CREATE = "entrepreneurBusinessplan38Create";
    public static String TABLE_ENTREPRENEUR_BUSINESSPLAN_3_9_CREATE = "entrepreneurBusinessplan39Create";
    public static String TABLE_ENTREPRENEUR_BUSINESSPLAN_3_10_CREATE = "entrepreneurBusinessplan310Create";
    public static String TABLE_ENTREPRENEUR_BUSINESSPLAN_4_0_CREATE = "entrepreneurBusinessplan40Create";
    public static String TABLE_CREATE_CAMPAIGN = "createCampaign";
    public static String TABLE_CREATE_EVENT_MEMBER_TABLE= "createEventMemberTable";
    public static String TABLE_CREATE_ENTERPRISE_REGISTRATION= "createEnterpriseRegistration";
    public static String TABLE_CREATE_ENTERPRISE_TRACKING= "createEnterpriseTracking";

    //COMMON KEYS
    public static String KEY_ID = "id";
    public static String KEY_LATITUDE = "keyLatitude";
    public static String KEY_LONGITUDE = "keyLongitude";
    public static String KEY_USER_ID = "keyUserId";
    public static String KEY_CREATED_BY = "keyCreatedBy";
    public static String KEY_ENTERPRENEUR_ID = "keyEnterpreneurID";
    public static String KEY_CREATED_DATE = "keyCreatedDate";


    // States Table Columns names
    public static String KEY_STATE_NAME = "stateName";
    public static String KEY_STATE_ID = "stateId";
    public static String KEY_STATE_CODE = "stateCode";


    // District Table Columns names
    public static String KEY_DISTRICT_ID = "districtId";
    public static String KEY_DISTRICT_NAME = "districtName";
    public static String KEY_DISTRICT_STATE_ID = "stateId";

    // Block Table Columns names
    public static String KEY_BLOCK_ID = "blockId";
    public static String KEY_BLOCK_NAME = "blockName";
    public static String KEY_BLOCK_DISTRICT_ID = "districtId";

    // Village Table Columns names
    public static String KEY_VILLAGE_ID = "villageId";
    public static String KEY_VILLAGE_NAME = "villageName";
    public static String KEY_VILLAGE_BLOCK_CODE = "GrampanchayatId";

    // Grampanchayat Table Columns names
    public static String KEY_GRAMPANCHAYAT_ID = "grampanchayatId";
    public static String KEY_GRAMPANCHAYAT_CODE = "grampanchayatCode";
    public static String KEY_GRAMPANCHAYAT_NAME = "grampanchayatName";

    //Religion list
    public static String KEY_RILIGION_ID = "religionID";
    public static String KEY_RILIGION_NAME = "religionName";

    //Cast list
    public static String KEY_CAST_ID = "castID";
    public static String KEY_CAST_NAME = "castName";

    //Create enterprenuer
    public static String KEY_CREATE_ENTERPRENEUR_ID = "keyEnterpreneurID";
    public static String KEY_CREATE_ENTERPRENEUR_ENTERPRISE_TYPE = "keyEnterpriseType";
    public static String KEY_CREATE_ENTERPRENEUR_ENTERPRISE_NAME = "keyEnterpriseName";
    public static String KEY_CREATE_ENTERPRENEUR_TYPE_OF_ENTERPRISE = "keyTypeOfEnterprise";
    public static String KEY_CREATE_ENTERPRENEUR_DESCRIPTION = "keyDescription";
    public static String KEY_CREATE_ENTERPRENEUR_FIRSTNAME = "keyfirstName";
    public static String KEY_CREATE_ENTERPRENEUR_MIDDLENAME = "keyMiddleName";
    public static String KEY_CREATE_ENTERPRENEUR_LASTNAME = "keyLastName";
    public static String KEY_CREATE_ENTERPRENEUR_BIRTHDATE = "keyBirthDate";
    public static String KEY_CREATE_ENTERPRENEUR_GENDER = "keyGender";
    public static String KEY_CREATE_ENTERPRENEUR_EMAILID = "keyEmailID";
    public static String KEY_CREATE_ENTERPRENEUR_SOCIAL_CATEGORY = "keySocialCategory";
    public static String KEY_CREATE_ENTERPRENEUR_STATE = "keyState";
    public static String KEY_CREATE_ENTERPRENEUR_DISTRICT = "keyDistrict";
    public static String KEY_CREATE_ENTERPRENEUR_BLOCK = "keyBlock";
    public static String KEY_CREATE_ENTERPRENEUR_VILLEGE = "keyVillage";
    public static String KEY_CREATE_ENTERPRENEUR_RESIDENCE_ADDRESS = "keyResidenceAddress";
    public static String KEY_CREATE_ENTERPRENEUR_PINCODE = "keyPincode";
    public static String KEY_CREATE_ENTERPRENEUR_ADDHAR_NO = "keyAdharNo";
    public static String KEY_CREATE_ENTERPRENEUR_PAN_NO = "keyPanNo";
    public static String KEY_CREATE_ENTERPRENEUR_BANK_ACCOUNT_NO = "keyBankAccountNo";
    public static String KEY_CREATE_ENTERPRENEUR_BANK_NAME = "keyBankName";
    public static String KEY_CREATE_ENTERPRENEUR_BRANCH_NAME = "keyBranchName";
    public static String KEY_CREATE_ENTERPRENEUR_BANK_IFSC = "keyBankIFSC";
    public static String KEY_CREATE_ENTERPRENEUR_MARITAL_STATUS = "keyMaritalStatus";
    public static String KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_CREATED = "keyIsBusinessPlanCreated";
    public static String KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_SUBMITTED = "keyIsBusinessPlanSubmitted";
    public static String KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_IS_MODEL = "keyIsBusinessPlanIsModel";
    public static String KEY_CREATE_ENTERPRENEUR_IS_ENTERPRISE_REGISTRED = "keyIsEnterpriseRegistered";
    public static String KEY_CREATE_ENTERPRENEUR_FULL_NAME = "keyFullName";
    public static String KEY_CREATE_ENTERPRENEUR_ENROLLMENT_DATE = "keyEnrollmentDate";
    public static String KEY_CREATE_ENTERPRENEUR_NO_OF_DEPENDENT = "keyNoOfDependent";
    public static String KEY_CREATE_ENTERPRENEUR_IS_JOIN_EVENT = "keyJoinEvent";
    public static String KEY_CREATE_ENTERPRENEUR_EVENT_NAME = "keyEventName";
    public static String KEY_CREATE_ENTERPRENEUR_PARICIPANT_NAME = "keyParticipantName";

    // Entrepreneur Family Education Qualification Table Columns names
    public static String KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_CREATED_BY_GET = "entrepreneurEduQualDetailsCreatedByGet";
    public static String KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_MODIFIED_BY_GET = "entrepreneurExpenditureDetailsModifiedByGet";
    public static String KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_CREATED_DATE_GET = "entrepreneurExpenditureDetailsCreatedDateGet";
    public static String KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_ID_GET = "entrepreneurExpenditureDetailsIdGet";
    public static String KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_QUALIFICATION_NAME_GET = "entrepreneurExpenditureDetailsQualificationNameGet";
    public static String KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_UNIVERSITY_NAME_GET = "entrepreneurExpenditureDetailsUniversityNameGet";
    public static String KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_PASSING_YEAR_GET = "entrepreneurExpenditureDetailsPassingYearGet";
    public static String KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_MAJOR_SUBJECT_GET = "entrepreneurExpenditureDetailsMajorSubjectGet";
    public static String KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_ENTREPRENEUR_ID_GET = "entrepreneurExpenditureDetailsEntrepreneurIdGet";
    public static String KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_DELETED_GET = "entrepreneurExpenditureDetailsDeletedGet";

    // Entrepreneur Family Education Qualification Table Columns names
    public static String KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_ID_GET = "entrepreneurSpecialTrainingIdGet";
    public static String KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_SUBJECT_GET = "entrepreneurSpecialTrainingSubjectGet";
    public static String KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_INSTITUTE_GET = "entrepreneurSpecialTrainingInstituteGet";
    public static String KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_DURATION_GET = "entrepreneurSpecialTrainingDurationGet";
    public static String KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_LEARNING_GET = "entrepreneurSpecialTrainingLearningGet";
    public static String KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_RNTREPRENEUR_ID_GET = "entrepreneurSpecialTrainingEntrepreneurIdGet";

    // Entrepreneur Family Work Experience Table Columns names
    public static String KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_ID_GET = "entrepreneurWorkExperienceIdGet";
    public static String KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_ORGANISATION_GET = "entrepreneurWorkExperienceOrganisationGet";
    public static String KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_DESIGNATION_GET = "entrepreneurWorkExperienceDesignationGet";
    public static String KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_JOB_PROFILE_GET = "entrepreneurWorkExperienceJobProfileGet";
    public static String KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_DURATION_GET = "entrepreneurWorkExperienceDurationGet";
    public static String KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_ENTREPRENEUR_ID_GET = "entrepreneurWorkExperienceEntrepreneurIdGet";

    //Entrepreneur Education & Job Details
    public static String KEY_ENTREPRENEUR_EDU_JOB_ENTREPRENEUR_ID = "entrepreneurEduJobEntrepreneurId";
    public static String KEY_ENTREPRENEUR_EDU_JOB_EDUCATION = "entrepreneurEduJobEducation";
    public static String KEY_ENTREPRENEUR_EDU_JOB_SPECIAL_TRAINING = "entrepreneurEduJobSpecialTraining";
    public static String KEY_ENTREPRENEUR_EDU_JOB_EORK_EXPERIENCE = "entrepreneurEduJobWorkExperience";

    //---- Entreprenuer  Traininig Detials ---//
    public static String KEY_ENTREPRENEUR_TRAINING_ID_PK = "trainingId";
    public static String KEY_ENTREPRENEUR_TRAINING_ENTREPRENEUR_ID = "trainingEntrepreneurId";
    public static String KEY_ENTREPRENEUR_TRAINING_NAME = "trainingName";
    public static String KEY_ENTREPRENEUR_TRAINING_START_DATE = "trainingStartDate";
    public static String KEY_ENTREPRENEUR_TRAINING_END_DATE = "trainingEndDate";
    public static String KEY_ENTREPRENEUR_TRAINING_DESCRIPTION = "trainingDescription";
    public static String KEY_ENTREPRENEUR_TRAINING_LATITUDE = "trainingLatitude";
    public static String KEY_ENTREPRENEUR_TRAINING_LONGITUDE = "trainingLongitude";
    public static String KEY_ENTREPRENEUR_TRAINING_CREATED_DATE = "trainingCreatedDate";
    public static String KEY_ENTREPRENEUR_TRAINING_CREATED_BY = "trainingCreatedBy";

    //---- New growth plan Growth purpose List ---- //
    public static String KEY_NEW_GROWTH_PLAN_PURPOSE_ID = "newGrowthPlanPurposeId";
    public static String KEY_NEW_GROWTH_PLAN_PURPOSE_VALUE = "newGrowthPlanPurposeValue";

    //-----(Entrepreneur Expenditure registration)---------//
    public static String KEY_ENTREPRENEUR_EXPENDITURE = "entrepreneurExpenditure";

    // Entrepreneur Family Credits List Table Columns names
    public static String KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_CREATED_BY_GET = "entrepreneurExpenditureDetailsCreatedByGet";
    public static String KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_MODIFIED_BY_GET = "entrepreneurExpenditureDetailsModifiedByGet";
    public static String KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_CREATED_DATE_GET = "entrepreneurExpenditureDetailsCreatedDateGet";
    public static String KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ID_GET = "entrepreneurExpenditureDetailsIdGet";
    public static String KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ITEM_TYPE_GET = "entrepreneurExpenditureDetailsItemTypeGet";
    public static String KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_MONTHLY_EXPENSE_GET = "entrepreneurExpenditureDetailsMonthlyExpenseGet";
    public static String KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ANNUAL_EXPENSE_GET = "entrepreneurExpenditureDetailsAnnualExpenseGet";
    public static String KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ENTREPRENEUR_ID_GET = "entrepreneurExpenditureDetailsEntrepreneurIdGet";
    public static String KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ITEM_TYPE_ID_GET = "entrepreneurExpenditureDetailsItemTypeIdGet";
    public static String KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_LONGITUDE_GET = "entrepreneurExpenditureDetailsLongitudeGet";
    public static String KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_LATITUDE_GET = "entrepreneurExpenditureDetailsLatitudeGet";
    public static String KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_DELETED_GET = "entrepreneurExpenditureDetailsDeletedGet";


    //ENTEPRENEUR INCOME PROFILE
    public static String KEY_ENTREPRENEUR_INCOME_ANNUAL_INCOME = "entrepreneurIncomeAnnualncome";
    public static String KEY_ENTREPRENEUR_INCOME_ANNUAL_INCOME_ID = "entrepreneurIncomeAnnualncomeId";
    public static String KEY_ENTREPRENEUR_INCOME_SELF_INCOME = "entrepreneurIncomeSelfIncome";
    public static String KEY_ENTREPRENEUR_INCOME_SELF_INCOME_ID = "entrepreneurIncomeSelfIncomeID";

    //-----(Entrepreneur Businessplan Creation Form - 1.0)---------//
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_NAME_OF_UNIT = "entrepreneurBusinessplan10NameOfUnit";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_ADDRESS_OF_UNIT = "entrepreneurBusinessplan10AddressOfUnit";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_ENTREPRENEUR_ID = "entrepreneurBusinessplan10EntrepreneurId";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_BP_ID = "entrepreneurBusinessplan10BPId";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_PRODUCT_ID = "entrepreneurBusinessplan10ProductId";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_NATURE_OF_ID = "entrepreneurBusinessplan10NatureOfUnitId";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_TYPE_OF_ID = "entrepreneurBusinessplan10TypeOfUnitId";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_PLACE_ID = "entrepreneurBusinessplan10PlaceId";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_IS_GOVT_LICENCE = "entrepreneurBusinessplan10IsGovtLicence";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_PINCODE = "entrepreneurBusinessplan10Pincode";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_STATE_ID = "entrepreneurBusinessplan10StateId";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_DISTRICT_ID = "entrepreneurBusinessplan10DistrictId";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_BLOCK_ID = "entrepreneurBusinessplan10BlockId";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_VILLAGE_ID = "entrepreneurBusinessplan10VillageId";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_LICENCE_DATE = "entrepreneurBusinessplan10LicenceDate";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_LICENCE_REG_NO = "entrepreneurBusinessplan10LicenceRegNo";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_TYPE_NO = "entrepreneurBusinessplan10TypeNo";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_SECTOR_NO = "entrepreneurBusinessplan10SectorNo";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_GRAMPANCHAYAT_ID = "entrepreneurBusinessplan10GrampanchayatId_";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_CREATED_DATE = "entrepreneurBusinessplan10CreatedDate";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_BP_FLAG = "entrepreneurBusinessplan10SubmittedFlag";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_BP_SYNC_STATUS = "entrepreneurBusinessplan10SyncStatus";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_IS_MODEL_BUSINESS_PLAN = "entrepreneurBusinessplan10isBusinessModel";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_IS_BUSINESS_PLAN_SUBMITE = "entrepreneurBusinessplan10isBusinessPlanSubmit";

    //---- New Business Plan by ketan patel---- //
    public static String KEY_NEW_BUSINESS_PLAN_ITEM_ID = "newBusinessPlanItemID";
    public static String KEY_NEW_BUSINESS_PLAN_ID = "newBusinessPlanID";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_20_PRODUCT_NAME = "newBusinessPlanProductName";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_20_WORKING_UNITES = "newBusinessWorkingUnits";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_20_ENTER_WORKING_UNITES = "newBusinessEnterWorkingUnits";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_20_PER_DAY_EIGHT_HOURS = "newBusinessPlanPerDayEightHours";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_PRODUCTION = "newBusinessTotalProduction";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_20_PER_DAY_SIXTY_PERCENT = "newBusinessPlanPerDaySixtyPercent";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_UTILIZATION = "newBusinessPlanTotalUtilization";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_20_SALE_PRICE_PER_UNIT = "newBusinessPlanSalePricePerUnit";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_20_AMOUNT = "newBusinessPlanAmount";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_20_SALE_IN_PERCENTAGE = "newBusinessPlanSaleInPercetage";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_20_IS_FIELD_EDITBLE = "newBusinessPlanIsFieldEditble";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_20_COST_PRICE = "newBusinessPlanCostPrice";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_COST_PRICE = "newBusinessPlanTotalCostPrice";

    //-----(Entrepreneur Businessplan Creation Form - 2.3)---------//
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_PRODUCT = "entrepreneurBusinessplan21Particulars";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_AMOUNT = "entrepreneurBusinessplan21Amount";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_BUSINESSPLAN_ID = "entrepreneurBusinessplan21BusinessplanId";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_ENTREPRENEUR_ID = "entrepreneurBusinessplan21EntrepreneurId";

    //-----(Entrepreneur Businessplan Creation Form - 3.0)---------//
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_0_LIST_OF_PREOPERATIVES = "entrepreneurBusinessplan30PreOperativeList";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_0_BUSINESSPLAN_ID = "entrepreneurBusinessplan30BusinessplanId";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_0_ENTREPRENEUR_ID = "entrepreneurBusinessplan30EntrepreneurId";

    //-----(Entrepreneur Businessplan Creation Form - 3.1)---------//
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_1_LIST_OF_LAND_BUILDINGS = "entrepreneurBusinessplan31LandBuildings";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_1_BUSINESSPLAN_ID = "entrepreneurBusinessplan31BusinessplanId";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_1_ENTREPRENEUR_ID = "entrepreneurBusinessplan31EntrepreneurId";

    //---- New Business Plan step 3.2 plant and machinery by ketan patel---- //
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_2_ITEM_ID = "entrepreneurBusinessplanItemID_3_2";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_2_BUSINESS_PLAN_ID = "entrepreneurBusinessplanID_3_2";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_2_PERTICULER = "entrepreneurBusinessplanPerticuler_3_2";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_2_NO = "entrepreneurBusinessplanPlanNo_3_2";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_2_PRICE = "entrepreneurBusinessplanPrice_3_2";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_2_AMOUNT = "entrepreneurBusinessplanAmount_3_2";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_2_PURCHASE_DATE = "entrepreneurBusinessplanPurchaseDate_3_2";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_2_EXPECTED_LIFE = "entrepreneurBusinessplanExpectedLife_3_2";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_2_SCRAP_VALUE = "entrepreneurBusinessplanScrapValue_3_2";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_2_DEPRICIATION = "entrepreneurBusinessplanDepriciation_3_2";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_2_BOOK_VALUE = "entrepreneurBusinessplanBookValue_3_2";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_2_SUPPLIERS_ADDRESS = "entrepreneurBusinessplanSuppliersAddress_3_2";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_2_TAX_TRANSPORTATION = "entrepreneurBusinessplanTaxTransporatation_3_2";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_2_ELECTRIFICATION = "entrepreneurBusinessplanLElectrification_3_2";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_2_UPLOAD_QUOTATION = "entrepreneurBusinessplanUploadQuotation_3_2";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_2_IS_FIELD_EDITABLE = "entrepreneurBusinessplanIsFieldEditble_3_2";

    //---- New Business Plan step 3.3 Furniture by ketan patel---- //
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_3_ITEM_ID = "entrepreneurBusinessPlanItemID_3_3";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_3_BUSINESS_PLAN_ID = "entrepreneurBusinessPlanID_3_3";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_3_PERTICULER = "entrepreneurBusinessPlanPerticuler_3_3";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_3_NO = "entrepreneurBusinessPlanNo_3_3";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_3_PRICE = "entrepreneurBusinessPlanPrice_3_3";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_3_AMOUNT = "entrepreneurBusinessAmount_3_3";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_3_PURCHASE_DATE = "entrepreneurBusinessPlanPurchaseDate_3_3";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_3_EXPECTED_LIFE = "entrepreneurBusinessPlanExpectedLife_3_3";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_3_SCRAP_VALUE = "entrepreneurBusinessPlanScrapValue_3_3";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_3_DEPRICIATION = "entrepreneurBusinessPlanDepriciation_3_3";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_3_BOOK_VALUE = "entrepreneurBusinessPlanBookValue_3_3";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_3_SUPPLIERS_ADDRESS = "entrepreneurBusinessPlanSuppliersAddress_3_3";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_3_UPLOAD_QUPTATIONS = "entrepreneurBusinessPlanUploadQuotations";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_3_IS_FIELD_EDITABLE = "entrepreneurBusinessPlanIsFieldEditble_3_3";

    //---- New Business Plan step 3.4 Raw materiels by ketan patel---- //
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEM_ID = "entrepreneurBusinessPlanItemID_3_4";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_4_BUSINESS_PLAN_ID = "entrepreneurBusinessPlanID_3_4";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEMS = "entrepreneurBusinessPlanItems_3_4";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_4_FOR_MONTHS = "entrepreneurBusinessPlanForMonths_3_4";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_4_QUANTITY_PER_UNIT = "entrepreneurBusinessPlanPerUnit_3_4";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_4_UNIT_RATE = "entrepreneurBusinessUnitrate_3_4";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_4_TOTAL_RATE = "entrepreneurBusinessTotalRate_3_4";
    public static String KEY_NEW_BUSINESS_PLAN_STEP_3_4_IS_FIELD_EDITABLE = "entrepreneurBusinessIsEditable_3_4";

    //-----(Entrepreneur Businessplan Creation Form - 3.5)---------//
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_5_LIST_OF_UTILITIES = "entrepreneurBusinessplan35Utilities";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_5_BUSINESSPLAN_ID = "entrepreneurBusinessplan35BusinessplanId";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_5_ENTREPRENEUR_ID = "entrepreneurBusinessplan35EntrepreneurId";


    //-----(Entrepreneur Businessplan Creation Form - 3.6)---------//
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_6_LIST_OF_MANPOWERS = "entrepreneurBusinessplan36Manpowers";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_6_BUSINESSPLAN_ID = "entrepreneurBusinessplan36BusinessplanId";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_6_ENTREPRENEUR_ID = "entrepreneurBusinessplan36EntrepreneurId";

    //-----(Entrepreneur Businessplan Creation Form - 3.7)---------//
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_7_LIST_OF_ADMINISTRATIVES = "entrepreneurBusinessplan37Administrative";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_7_BUSINESSPLAN_ID = "entrepreneurBusinessplan37BusinessplanId";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_7_ENTREPRENEUR_ID = "entrepreneurBusinessplan37EntrepreneurId";

    //-----(Entrepreneur Businessplan Creation Form - 3.8)---------//
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_8_LIST_OF_SELLING = "entrepreneurBusinessplan38Selling";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_8_BUSINESSPLAN_ID = "entrepreneurBusinessplan38BusinessplanId";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_8_ENTREPRENEUR_ID = "entrepreneurBusinessplan38EntrepreneurId";

    //-----(Entrepreneur Businessplan Creation Form - 3.9)---------//
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_9_LIST_OF_WORKING_CAPITALS = "entrepreneurBusinessplan39WorkingCapitals";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_9_BUSINESSPLAN_ID = "entrepreneurBusinessplan39BusinessplanId";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_9_ENTREPRENEUR_ID = "entrepreneurBusinessplan39EntrepreneurId";

    //-----(Entrepreneur Businessplan Creation Form - 3.10)---------//
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_10_TOTAL_COST_ODF_PROJECT = "entrepreneurBusinessplan310TotalProjectCost";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_10_BUSINESSPLAN_ID = "entrepreneurBusinessplan310BusinessplanId";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_3_10_ENTREPRENEUR_ID = "entrepreneurBusinessplan310EntrepreneurId";

    //-----(Entrepreneur Businessplan Creation Form - 4.0)---------//
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_4_0_LIST_OF_MEANS_OF_FINANCE = "entrepreneurBusinessplan40MeansOfFinance";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_4_0_BUSINESSPLAN_ID = "entrepreneurBusinessplan40BusinessplanId";
    public static String KEY_ENTREPRENEUR_BUSINESSPLAN_4_0_ENTREPRENEUR_ID = "entrepreneurBusinessplan40EntrepreneurId";

    //FIELD FOR CREATE CAMPAIGN
    public  static String KEY_CREATE_CAMPAIGN_ID ="campaignID";
    public  static String KEY_CREATE_CAMPAIGN_NAME ="campaignName";
    public  static String KEY_CREATE_CAMPAIGN_DATE ="campaignDate";
    public  static String KEY_CREATE_CAMPAIGN_ADDRESS ="campaignAddress";
    public  static String KEY_CREATE_CAMPAIGN_MORE_INFO ="campaignMoreInfo";
    public  static String KEY_CREATE_CAMPAIGN_MOBILE_USER_ID="campaignMobileUserID";

    //FIELD FOR CREATE MEMBERS
    public static String KEY_CREATE_MEMBER_NAME ="createMemberName";
    public static String KEY_CREATE_MEMBER_BIRTH_DATE ="createMemberBirthDate";
    public static String KEY_CREATE_MEMBER_PHONE_NUMBER ="createMemberPhoneNumber";
    public static String KEY_CREATE_MEMBER_ID ="createMemberID";
    public static String KEY_CREATE_MEMBER_MOBILE_USER_NAME_ID ="createMemberMobileUserID";
    public static String KEY_CREATE_MEMBER_CREAETED_DATE ="createMemberCreatedDate";
    public static String KEY_CREATE_MEMBER_EVENT_ID ="createMemberEventID";

    //FIELD FOR CREATE TABLE ENTERPRISE REGISTRATION
    public static String KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRENEUR_NAME ="createEnterpriseEnterpreneurName";
    public static String KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRISE_NAME ="createEnterpriseEnterpriseName";
    public static String KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRENEUR_ID ="createEnterpriseEnterpreneurID";
    public static String KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRISE_ID ="createEnterpriseEnterpriseID";
    public static String KEY_CREATE_ENTERPRISE_REGISTRATION_BLOCK_ID ="createEnterpriseBlockID";
    public static String KEY_CREATE_ENTERPRISE_REGISTRATION_VILLAGE_ID ="createEnterpriseVillageID";
    public static String KEY_CREATE_ENTERPRISE_REGISTRATION_STARTING_DATE ="createEnterpriseStartingDate";
    public static String KEY_CREATE_ENTERPRISE_REGISTRATION_IMAGE_URL ="createEnterpriseImageURL";
    public static String KEY_CREATE_ENTERPRISE_REGISTRATION_CREATED_DATE ="createEnterpriseCreatedDate";


    //FIELD FOR CREATE TABLE ENTERPRISE TRACKING
    public static String KEY_CREATE_ENTERPRISE_TRACKING_ENTERPRISE_NAME ="createEnterpriseTrackingEnterpriseName";
    public static String KEY_CREATE_ENTERPRISE_TRACKING_ENTERPRISE_ID ="createEnterpriseTrackingEnterpriseID";
    public static String KEY_CREATE_ENTERPRISE_TRACKING_ENTERPRENEURE_ID ="createEnterpriseTrackingEnterpreneurID";
    public static String KEY_CREATE_ENTERPRISE_TRACKING_MOBILE_USER_ID ="createEnterpriseTrackingMobileUserID";
    public static String KEY_CREATE_ENTERPRISE_TRACKING_STATUS ="createEnterpriseTrackingStatus";
    public static String KEY_CREATE_ENTERPRISE_TRACKING_TURNOVER ="createEnterpriseTrackingTurnOver";
    public static String KEY_CREATE_ENTERPRISE_TRACKING_PROFITES ="createEnterpriseTrackingProfit";
    public static String KEY_CREATE_ENTERPRISE_TRACKING_PEAPOLE_EMPLOYED ="createEnterpriseTrackingPeopleEmployed";
    public static String KEY_CREATE_ENTERPRISE_TRACKING_CAPITAL_DEPLOY ="createEnterpriseTrackingCapitalDeploy";
    public static String KEY_CREATE_ENTERPRISE_TRACKING_RETURN_ON_INVESTMENT ="createEnterpriseTrackingReturnOnInvestment";
    public static String KEY_CREATE_ENTERPRISE_TRACKING_PROFITE_AS_PERCENTAGE ="createEnterpriseTrackingProfitAsPercentage";
    public static String KEY_CREATE_ENTERPRISE_TRACKING_CURRENT_TIME ="createEnterpriseTrackingCurrentTime";



    DatabaseManager dbManager;
    Context mContext;
    Cursor result = null;
    private static SQLiteDatabase mSqLiteDatabase;


    public DatabaseHelper(Context mContext) {
        // TODO Auto-generated constructor stub
        this.mContext = mContext;
        dbManager = DatabaseManager.getInstance(mContext, DATABASE_NAME, null,
                DATABASE_VERSION);

    }

    public void open() {
        if (mSqLiteDatabase == null || mSqLiteDatabase.isOpen())
            mSqLiteDatabase = dbManager.getWritableDatabase();
    }

    public void close() {

        mSqLiteDatabase.close();
    }

    //INSERT AND GET STATE LIST
    public Long insertState(String stateName, Long stateId, String stateCode) {

        ContentValues values = new ContentValues();
        values.put(KEY_STATE_NAME, stateName);
        values.put(KEY_STATE_ID, stateId);
        values.put(KEY_STATE_CODE, stateCode);
        return mSqLiteDatabase.insert(TABLE_STATES, null, values);

    }

    public ArrayList<StateListModel> getStateList() {
        ArrayList<StateListModel> mListStateBeen = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query(TABLE_STATES, new String[]{}, null, null,
                    null, null, null);

            if (result.moveToFirst()) {
                do {
                    StateListModel mListStateBean = new StateListModel();
                    mListStateBean.setStrStateName(result.getString(1));
                    mListStateBean.setIntStateID(result.getLong(2));
                    mListStateBean.setStrStateCode(result.getString(3));
                    mListStateBeen.add(mListStateBean);

                    Collections.sort(mListStateBeen, new Comparator<StateListModel>() {
                        public int compare(StateListModel v1, StateListModel v2) {
                            return v1.getStrStateName().compareTo(v2.getStrStateName());
                        }
                    });

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }


        return mListStateBeen;
    }

    public ArrayList<StateListModel> getStateDataFromStateID(Long stateID) {
        ArrayList<StateListModel> mListStateBeen = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query(TABLE_STATES, new String[]{}, null, null,
                    null, null, null);

            result = mSqLiteDatabase.query
                    (
                            TABLE_STATES,
                            new String[]{KEY_ID,
                                    KEY_STATE_NAME,
                                    KEY_STATE_ID,
                                    KEY_STATE_CODE},
                            KEY_STATE_ID + "=" + stateID,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {
                do {
                    StateListModel mListStateBean = new StateListModel();
                    mListStateBean.setStrStateName(result.getString(1));
                    mListStateBean.setIntStateID(result.getLong(2));
                    mListStateBean.setStrStateCode(result.getString(3));
                    mListStateBeen.add(mListStateBean);

                    Collections.sort(mListStateBeen, new Comparator<StateListModel>() {
                        public int compare(StateListModel v1, StateListModel v2) {
                            return v1.getStrStateName().compareTo(v2.getStrStateName());
                        }
                    });

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }


        return mListStateBeen;
    }


    //INSERT AND GET DISTRINCT LIST
    public Long insertDistrinct(Long distrinctID, String distrinctName, int stateCode) {

        ContentValues values = new ContentValues();
        values.put(KEY_DISTRICT_ID, distrinctID);
        values.put(KEY_DISTRICT_NAME, distrinctName);
        values.put(KEY_DISTRICT_STATE_ID, stateCode);
        return mSqLiteDatabase.insert(TABLE_DISTRICT, null, values);

    }

    public ArrayList<DistrinctListModel> getDistrictListAll() {
        ArrayList<DistrinctListModel> distrinctListModels = new ArrayList<>();
        result = null;
        try {

            result = mSqLiteDatabase.query(TABLE_DISTRICT, new String[]{}, null, null,
                    null, null, null);

            if (result.moveToFirst()) {
                do {
                    DistrinctListModel mDistrinctListModel = new DistrinctListModel();
                    mDistrinctListModel.setIntDistrinctID(result.getLong(1));
                    mDistrinctListModel.setStrDistrictName(result.getString(2));
                    mDistrinctListModel.setIntStateID(result.getInt(3));
                    distrinctListModels.add(mDistrinctListModel);

                    Collections.sort(distrinctListModels, new Comparator<DistrinctListModel>() {
                        public int compare(DistrinctListModel v1, DistrinctListModel v2) {
                            return v1.getStrDistrictName().compareTo(v2.getStrDistrictName());
                        }
                    });


                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }


        return distrinctListModels;
    }

    public ArrayList<DistrinctListModel> getDistrinctDataFromID(Long distrinctID) {
        ArrayList<DistrinctListModel> distrinctListModels = new ArrayList<>();
        result = null;
        try {

            result = mSqLiteDatabase.query
                    (
                            TABLE_DISTRICT,
                            new String[]{KEY_ID,
                                    KEY_DISTRICT_ID,
                                    KEY_DISTRICT_NAME,
                                    KEY_DISTRICT_STATE_ID},
                            KEY_DISTRICT_ID + "=" + distrinctID,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {
                do {
                    DistrinctListModel mDistrinctListModel = new DistrinctListModel();
                    mDistrinctListModel.setIntDistrinctID(result.getLong(1));
                    mDistrinctListModel.setStrDistrictName(result.getString(2));
                    mDistrinctListModel.setIntStateID(result.getInt(3));
                    distrinctListModels.add(mDistrinctListModel);

                    Collections.sort(distrinctListModels, new Comparator<DistrinctListModel>() {
                        public int compare(DistrinctListModel v1, DistrinctListModel v2) {
                            return v1.getStrDistrictName().compareTo(v2.getStrDistrictName());
                        }
                    });


                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }


        return distrinctListModels;
    }

    public ArrayList<DistrinctListModel> getDistrictListByStateID(Long lngStateID) {
        ArrayList<DistrinctListModel> distrinctListModels = new ArrayList<>();
        result = null;
        try {

            result = mSqLiteDatabase.query
                    (
                            TABLE_DISTRICT,
                            new String[]{KEY_ID,
                                    KEY_DISTRICT_ID,
                                    KEY_DISTRICT_NAME,
                                    KEY_DISTRICT_STATE_ID},
                            KEY_DISTRICT_STATE_ID + "=" + lngStateID,
                            null, null, null, null, null
                    );

            if (result.moveToFirst()) {
                do {
                    DistrinctListModel mDistrinctListModel = new DistrinctListModel();
                    mDistrinctListModel.setIntDistrinctID(result.getLong(1));
                    mDistrinctListModel.setStrDistrictName(result.getString(2));
                    mDistrinctListModel.setIntStateID(result.getInt(3));
                    distrinctListModels.add(mDistrinctListModel);

                    Collections.sort(distrinctListModels, new Comparator<DistrinctListModel>() {
                        public int compare(DistrinctListModel v1, DistrinctListModel v2) {
                            return v1.getStrDistrictName().compareTo(v2.getStrDistrictName());
                        }
                    });


                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }


        return distrinctListModels;
    }


    //INSERT AND GET BLOCK LIST
    public Long insertBlockList(Long blockId, String blockName, int blockDistrictId) {

        ContentValues values = new ContentValues();
        values.put(KEY_BLOCK_ID, blockId);
        values.put(KEY_BLOCK_NAME, blockName);
        values.put(KEY_BLOCK_DISTRICT_ID, blockDistrictId);
        return mSqLiteDatabase.insert(TABLE_BLOCK, null, values);

    }

    public ArrayList<BlockListModel> getBlockListALL() {
        ArrayList<BlockListModel> blockListModels = new ArrayList<>();
        result = null;
        try {

            result = mSqLiteDatabase.query(TABLE_BLOCK, new String[]{}, null, null,
                    null, null, null);

            if (result.moveToFirst()) {

                do {
                    BlockListModel mDistrinctListModel = new BlockListModel();
                    mDistrinctListModel.setBlockId(result.getLong(1));
                    mDistrinctListModel.setBlockName(result.getString(2));
                    mDistrinctListModel.setBlockDistrictId(result.getLong(3));
                    blockListModels.add(mDistrinctListModel);

                    Collections.sort(blockListModels, new Comparator<BlockListModel>() {
                        public int compare(BlockListModel v1, BlockListModel v2) {
                            return v1.getBlockName().compareTo(v2.getBlockName());
                        }
                    });


                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }


        return blockListModels;
    }

    public ArrayList<BlockListModel> getBlockDataFromID(Long blockID) {
        ArrayList<BlockListModel> blockListModels = new ArrayList<>();
        result = null;
        try {

            result = mSqLiteDatabase.query
                    (
                            TABLE_BLOCK,
                            new String[]{KEY_ID,
                                    KEY_BLOCK_ID,
                                    KEY_BLOCK_NAME,
                                    KEY_BLOCK_DISTRICT_ID},
                            KEY_BLOCK_ID + "=" + blockID,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {

                do {
                    BlockListModel mDistrinctListModel = new BlockListModel();
                    mDistrinctListModel.setBlockId(result.getLong(1));
                    mDistrinctListModel.setBlockName(result.getString(2));
                    mDistrinctListModel.setBlockDistrictId(result.getLong(3));
                    blockListModels.add(mDistrinctListModel);

                    Collections.sort(blockListModels, new Comparator<BlockListModel>() {
                        public int compare(BlockListModel v1, BlockListModel v2) {
                            return v1.getBlockName().compareTo(v2.getBlockName());
                        }
                    });


                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }


        return blockListModels;
    }

    public ArrayList<BlockListModel> getBlockListFromDistrict(Long lngDistrictCode) {
        ArrayList<BlockListModel> blockListModels = new ArrayList<>();
        result = null;
        try {

            result = mSqLiteDatabase.query
                    (
                            TABLE_BLOCK,
                            new String[]{KEY_ID,
                                    KEY_BLOCK_ID,
                                    KEY_BLOCK_NAME,
                                    KEY_BLOCK_DISTRICT_ID},
                            KEY_BLOCK_DISTRICT_ID + "=" + lngDistrictCode,
                            null, null, null, null, null
                    );

            if (result.moveToFirst()) {

                do {
                    BlockListModel mDistrinctListModel = new BlockListModel();
                    mDistrinctListModel.setBlockId(result.getLong(1));
                    mDistrinctListModel.setBlockName(result.getString(2));
                    mDistrinctListModel.setBlockDistrictId(result.getLong(3));
                    blockListModels.add(mDistrinctListModel);

                    Collections.sort(blockListModels, new Comparator<BlockListModel>() {
                        public int compare(BlockListModel v1, BlockListModel v2) {
                            return v1.getBlockName().compareTo(v2.getBlockName());
                        }
                    });


                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }


        return blockListModels;
    }


    //-------(Insert and get Villege  List)------------//
    public Long insertVillegeList(Long villegeId, String villegeName, int blockCode) {

        ContentValues values = new ContentValues();
        values.put(KEY_VILLAGE_ID, villegeId);
        values.put(KEY_VILLAGE_NAME, villegeName);
        values.put(KEY_VILLAGE_BLOCK_CODE, blockCode);
        return mSqLiteDatabase.insert(TABLE_VILLAGE, null, values);

    }

    public ArrayList<VillegeListModel> getVillegeDataFromID(Long villegeID) {
        ArrayList<VillegeListModel> mVillegeList = new ArrayList<>();
        result = null;
        try {

            result = mSqLiteDatabase.query
                    (
                            TABLE_VILLAGE,
                            new String[]{KEY_ID,
                                    KEY_VILLAGE_ID,
                                    KEY_VILLAGE_NAME,
                                    KEY_VILLAGE_BLOCK_CODE},
                            KEY_VILLAGE_ID + "=" + villegeID,
                            null, null, null, null, null
                    );

            if (result.moveToFirst()) {
                do {
                    VillegeListModel mVillegeListModel = new VillegeListModel();
                    mVillegeListModel.setVillegeId(result.getLong(1));
                    mVillegeListModel.setVillegeName(result.getString(2));
                    mVillegeListModel.setVillegeBlockId(result.getLong(3));
                    mVillegeList.add(mVillegeListModel);

                    Collections.sort(mVillegeList, new Comparator<VillegeListModel>() {
                        public int compare(VillegeListModel v1, VillegeListModel v2) {
                            return v1.getVillegeName().compareTo(v2.getVillegeName());
                        }
                    });


                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }


        return mVillegeList;
    }

    public ArrayList<VillegeListModel> getVillegeListFromBlockCode(Long lngBlockCode) {
        ArrayList<VillegeListModel> mVillegeList = new ArrayList<>();
        result = null;
        try {

            result = mSqLiteDatabase.query
                    (
                            TABLE_VILLAGE,
                            new String[]{KEY_ID,
                                    KEY_VILLAGE_ID,
                                    KEY_VILLAGE_NAME,
                                    KEY_VILLAGE_BLOCK_CODE},
                            KEY_VILLAGE_BLOCK_CODE + "=" + lngBlockCode,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {
                do {
                    VillegeListModel mVillegeListModel = new VillegeListModel();
                    mVillegeListModel.setVillegeId(result.getLong(1));
                    mVillegeListModel.setVillegeName(result.getString(2));
                    mVillegeListModel.setGpCode(result.getString(3));
                    mVillegeList.add(mVillegeListModel);

                    Collections.sort(mVillegeList, new Comparator<VillegeListModel>() {
                        public int compare(VillegeListModel v1, VillegeListModel v2) {
                            return v1.getVillegeName().compareTo(v2.getVillegeName());
                        }
                    });

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }


        return mVillegeList;
    }

    //GET ALL VILLAGES
    public ArrayList<VillegeListModel> getVillegeList() {
        ArrayList<VillegeListModel> mVillegeList = new ArrayList<>();
        result = null;
        try {


            result = mSqLiteDatabase.query(TABLE_VILLAGE, new String[]{}, null, null,
                    null, null, null);


            if (result.moveToFirst()) {
                do {
                    VillegeListModel mVillegeListModel = new VillegeListModel();
                    mVillegeListModel.setVillegeId(result.getLong(1));
                    mVillegeListModel.setVillegeName(result.getString(2));
                    mVillegeListModel.setVillegeBlockId(result.getLong(3));
                    mVillegeList.add(mVillegeListModel);

                    Collections.sort(mVillegeList, new Comparator<VillegeListModel>() {
                        public int compare(VillegeListModel v1, VillegeListModel v2) {
                            return v1.getVillegeName().compareTo(v2.getVillegeName());
                        }
                    });


                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }


        return mVillegeList;
    }



    //INSERT GRAM PANCHAYAT LIST
    public Long insertGrampanchayatList(Long grampanchayatId, String grampanchayatName, String grampanchayatCode) {

        ContentValues values = new ContentValues();
        values.put(KEY_GRAMPANCHAYAT_ID, grampanchayatId);
        values.put(KEY_GRAMPANCHAYAT_NAME, grampanchayatName);
        values.put(KEY_GRAMPANCHAYAT_CODE, grampanchayatCode);
        return mSqLiteDatabase.insert(TABLE_GRAMPANCHAYAT, null, values);

    }

    public ArrayList<UserBasicDetailsModel.DataBean.ListGramPanchayatBean> getGrampanchayatLists(String strGrampanchayatId) {
        ArrayList<UserBasicDetailsModel.DataBean.ListGramPanchayatBean> mGPList = new ArrayList<>();
        result = null;
        try {

            result = mSqLiteDatabase.query
                    (
                            TABLE_GRAMPANCHAYAT,
                            new String[]{KEY_ID
                                    , KEY_GRAMPANCHAYAT_ID,
                                    KEY_GRAMPANCHAYAT_NAME,
                                    KEY_GRAMPANCHAYAT_CODE},
                            KEY_GRAMPANCHAYAT_CODE + "=" + strGrampanchayatId,
                            null, null, null, null, null
                    );

            if (result.moveToFirst()) {
                do {
                    UserBasicDetailsModel.DataBean.ListGramPanchayatBean mGPlistModel = new UserBasicDetailsModel.DataBean.ListGramPanchayatBean();
                    mGPlistModel.setGrampanchayatId(result.getLong(1));
                    mGPlistModel.setGrampanchayatName(result.getString(2));
                    mGPlistModel.setGrampanchayatCode(result.getString(3));
                    mGPList.add(mGPlistModel);

                    Collections.sort(mGPList, new Comparator<UserBasicDetailsModel.DataBean.ListGramPanchayatBean>() {
                        public int compare(UserBasicDetailsModel.DataBean.ListGramPanchayatBean v1, UserBasicDetailsModel.DataBean.ListGramPanchayatBean v2) {
                            return v1.getGrampanchayatName().compareTo(v2.getGrampanchayatName());
                        }
                    });

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }


        return mGPList;
    }


    public ArrayList<UserBasicDetailsModel.DataBean.ListGramPanchayatBean> getAllGPList() {
        ArrayList<UserBasicDetailsModel.DataBean.ListGramPanchayatBean> gplistModelArrayList = new ArrayList<>();
        result = null;
        try {

            result = mSqLiteDatabase.query(TABLE_GRAMPANCHAYAT, new String[]{}, null, null,
                    null, null, null);

            if (result.moveToFirst()) {
                do {
                    UserBasicDetailsModel.DataBean.ListGramPanchayatBean mSHGlistModel = new UserBasicDetailsModel.DataBean.ListGramPanchayatBean();
                    mSHGlistModel.setGrampanchayatId(result.getLong(1));
                    mSHGlistModel.setGrampanchayatName(result.getString(2));
                    mSHGlistModel.setGrampanchayatCode(result.getString(3));
                    gplistModelArrayList.add(mSHGlistModel);

                    Collections.sort(gplistModelArrayList, new Comparator<UserBasicDetailsModel.DataBean.ListGramPanchayatBean>() {
                        public int compare(UserBasicDetailsModel.DataBean.ListGramPanchayatBean v1, UserBasicDetailsModel.DataBean.ListGramPanchayatBean v2) {
                            return v1.getGrampanchayatName().compareTo(v2.getGrampanchayatName());
                        }
                    });

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }


        return gplistModelArrayList;
    }

    //INSERT AND GET RELIGION LIST
    public Long insertReligionList(int religionID, String religionName) {

        ContentValues values = new ContentValues();
        values.put(KEY_RILIGION_ID, religionID);
        values.put(KEY_RILIGION_NAME, religionName);
        return mSqLiteDatabase.insert(TABLE_RELIGION_LIST, null, values);

    }

    public ArrayList<ReligionListModel> getReligionList() {
        ArrayList<ReligionListModel> mReligionListModelList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query(TABLE_RELIGION_LIST, new String[]{}, null, null,
                    null, null, null);

            if (result.moveToFirst()) {
                do {
                    ReligionListModel religionListModel = new ReligionListModel();
                    religionListModel.setReligionID(result.getInt(1));
                    religionListModel.setReligionName(result.getString(2));
                    mReligionListModelList.add(religionListModel);

                    Collections.sort(mReligionListModelList, new Comparator<ReligionListModel>() {
                        public int compare(ReligionListModel v1, ReligionListModel v2) {
                            return v1.getReligionName().compareTo(v2.getReligionName());
                        }
                    });

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mReligionListModelList;
    }

    public ArrayList<ReligionListModel> getReligionDateFromID(Long religionID) {
        ArrayList<ReligionListModel> mReligionListModelList = new ArrayList<>();

        try {

            result = mSqLiteDatabase.query
                    (
                            TABLE_RELIGION_LIST,
                            new String[]{KEY_ID,
                                    KEY_RILIGION_ID,
                                    KEY_RILIGION_NAME},
                            KEY_RILIGION_ID + "=" + religionID,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {
                do {
                    ReligionListModel religionListModel = new ReligionListModel();
                    religionListModel.setReligionID(result.getInt(1));
                    religionListModel.setReligionName(result.getString(2));
                    mReligionListModelList.add(religionListModel);

                    Collections.sort(mReligionListModelList, new Comparator<ReligionListModel>() {
                        public int compare(ReligionListModel v1, ReligionListModel v2) {
                            return v1.getReligionName().compareTo(v2.getReligionName());
                        }
                    });

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mReligionListModelList;
    }

    //INSERT CAST LIST
    public Long insertCastList(int castID, String castName) {

        ContentValues values = new ContentValues();
        values.put(KEY_CAST_ID, castID);
        values.put(KEY_CAST_NAME, castName);
        return mSqLiteDatabase.insert(TABLE_CAST_LIST, null, values);

    }

    public ArrayList<CastListModel> getCastList() {
        ArrayList<CastListModel> mCastListModelList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query(TABLE_CAST_LIST, new String[]{}, null, null,
                    null, null, null);

            if (result.moveToFirst()) {
                do {
                    CastListModel mCastListModel = new CastListModel(result.getString(2));
                    mCastListModel.setCastID(result.getInt(1));
                    mCastListModel.setCastName(result.getString(2));
                    mCastListModelList.add(mCastListModel);

                    Collections.sort(mCastListModelList, new Comparator<CastListModel>() {
                        public int compare(CastListModel v1, CastListModel v2) {
                            return v1.getCastName().compareTo(v2.getCastName());
                        }
                    });


                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mCastListModelList;

    }

    public ArrayList<CastListModel> getCastDataFromID(Long castID) {
        ArrayList<CastListModel> mCastListModelList = new ArrayList<>();

        try {

            result = mSqLiteDatabase.query
                    (
                            TABLE_CAST_LIST,
                            new String[]{KEY_ID,
                                    KEY_CAST_ID,
                                    KEY_CAST_NAME},
                            KEY_CAST_ID + "=" + castID,
                            null, null, null, null, null
                    );

            if (result.moveToFirst()) {
                do {
                    CastListModel mCastListModel = new CastListModel();
                    mCastListModel.setCastID(result.getInt(1));
                    mCastListModel.setCastName(result.getString(2));
                    mCastListModelList.add(mCastListModel);

                    Collections.sort(mCastListModelList, new Comparator<CastListModel>() {
                        public int compare(CastListModel v1, CastListModel v2) {
                            return v1.getCastName().compareTo(v2.getCastName());
                        }
                    });


                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mCastListModelList;

    }


    //INSERT, UPDATE AND DELETE ENTERPRENEUR DATA
    public Long insertCreateEnterpreneurData(Long KEY_CREATE_ENTERPRENEUR_ID,
                                             Long KEY_USER_ID,
                                             double KEY_LATITUDE,
                                             double KEY_LONGITUDE,
                                             String KEY_CREATE_ENTERPRENEUR_ENTERPRISE_TYPE,
                                             String KEY_CREATE_ENTERPRENEUR_ENTERPRISE_NAME,
                                             String KEY_CREATE_ENTERPRENEUR_TYPE_OF_ENTERPRISE,
                                             String KEY_CREATE_ENTERPRENEUR_DESCRIPTION,
                                             String KEY_CREATE_ENTERPRENEUR_FIRSTNAME,
                                             String KEY_CREATE_ENTERPRENEUR_MIDDLENAME,
                                             String KEY_CREATE_ENTERPRENEUR_LASTNAME,
                                             Long KEY_CREATE_ENTERPRENEUR_BIRTHDATE,
                                             String KEY_CREATE_ENTERPRENEUR_GENDER,
                                             String KEY_CREATE_ENTERPRENEUR_EMAILID,
                                             Long KEY_CREATE_ENTERPRENEUR_SOCIAL_CATEGORY,
                                             Long KEY_CREATE_ENTERPRENEUR_STATE,
                                             Long KEY_CREATE_ENTERPRENEUR_DISTRICT,
                                             Long KEY_CREATE_ENTERPRENEUR_BLOCK,
                                             Long KEY_CREATE_ENTERPRENEUR_VILLEGE,
                                             String KEY_CREATE_ENTERPRENEUR_RESIDENCE_ADDRESS,
                                             String KEY_CREATE_ENTERPRENEUR_PINCODE,
                                             String KEY_CREATE_ENTERPRENEUR_ADDHAR_NO,
                                             String KEY_CREATE_ENTERPRENEUR_PAN_NO,
                                             String KEY_CREATE_ENTERPRENEUR_BANK_ACCOUNT_NO,
                                             String KEY_CREATE_ENTERPRENEUR_BANK_NAME,
                                             String KEY_CREATE_ENTERPRENEUR_BRANCH_NAME,
                                             String KEY_CREATE_ENTERPRENEUR_BANK_IFSC,
                                             String KEY_CREATE_ENTERPRENEUR_MARITAL_STATUS,
                                             int KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_CREATED,
                                             int KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_SUBMITTED,
                                             int KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_IS_MODEL,
                                             int KEY_CREATE_ENTERPRENEUR_IS_ENTERPRISE_REGISTRED,
                                             String KEY_CREATE_ENTERPRENEUR_FULL_NAME,
                                             Long KEY_CREATE_ENTERPRENEUR_ENROLLMENT_DATE,
                                             int KEY_CREATE_ENTERPRENEUR_NO_OF_DEPENDENT,
                                             String KEY_CREATE_ENTERPRENEUR_IS_JOIN_EVENT,
                                             String KEY_CREATE_ENTERPRENEUR_EVENT_NAME,
                                             String KEY_CREATE_ENTERPRENEUR_PARICIPANT_NAME) {



        ContentValues values = new ContentValues();
        values.put(this.KEY_CREATE_ENTERPRENEUR_ID, KEY_CREATE_ENTERPRENEUR_ID);
        values.put(this.KEY_USER_ID, KEY_USER_ID);
        values.put(this.KEY_LATITUDE, KEY_LATITUDE);
        values.put(this.KEY_LONGITUDE, KEY_LONGITUDE);
        values.put(this.KEY_CREATE_ENTERPRENEUR_ENTERPRISE_TYPE, KEY_CREATE_ENTERPRENEUR_ENTERPRISE_TYPE);
        values.put(this.KEY_CREATE_ENTERPRENEUR_ENTERPRISE_NAME, KEY_CREATE_ENTERPRENEUR_ENTERPRISE_NAME);
        values.put(this.KEY_CREATE_ENTERPRENEUR_TYPE_OF_ENTERPRISE, KEY_CREATE_ENTERPRENEUR_TYPE_OF_ENTERPRISE);
        values.put(this.KEY_CREATE_ENTERPRENEUR_DESCRIPTION, KEY_CREATE_ENTERPRENEUR_DESCRIPTION);
        values.put(this.KEY_CREATE_ENTERPRENEUR_FIRSTNAME, KEY_CREATE_ENTERPRENEUR_FIRSTNAME);
        values.put(this.KEY_CREATE_ENTERPRENEUR_MIDDLENAME, KEY_CREATE_ENTERPRENEUR_MIDDLENAME);
        values.put(this.KEY_CREATE_ENTERPRENEUR_LASTNAME, KEY_CREATE_ENTERPRENEUR_LASTNAME);
        values.put(this.KEY_CREATE_ENTERPRENEUR_BIRTHDATE, KEY_CREATE_ENTERPRENEUR_BIRTHDATE);
        values.put(this.KEY_CREATE_ENTERPRENEUR_GENDER, KEY_CREATE_ENTERPRENEUR_GENDER);
        values.put(this.KEY_CREATE_ENTERPRENEUR_EMAILID, KEY_CREATE_ENTERPRENEUR_EMAILID);
        values.put(this.KEY_CREATE_ENTERPRENEUR_SOCIAL_CATEGORY, KEY_CREATE_ENTERPRENEUR_SOCIAL_CATEGORY);
        values.put(this.KEY_CREATE_ENTERPRENEUR_STATE, KEY_CREATE_ENTERPRENEUR_STATE);
        values.put(this.KEY_CREATE_ENTERPRENEUR_DISTRICT, KEY_CREATE_ENTERPRENEUR_DISTRICT);
        values.put(this.KEY_CREATE_ENTERPRENEUR_BLOCK, KEY_CREATE_ENTERPRENEUR_BLOCK);
        values.put(this.KEY_CREATE_ENTERPRENEUR_VILLEGE, KEY_CREATE_ENTERPRENEUR_VILLEGE);
        values.put(this.KEY_CREATE_ENTERPRENEUR_RESIDENCE_ADDRESS, KEY_CREATE_ENTERPRENEUR_RESIDENCE_ADDRESS);
        values.put(this.KEY_CREATE_ENTERPRENEUR_PINCODE, KEY_CREATE_ENTERPRENEUR_PINCODE);
        values.put(this.KEY_CREATE_ENTERPRENEUR_ADDHAR_NO, KEY_CREATE_ENTERPRENEUR_ADDHAR_NO);
        values.put(this.KEY_CREATE_ENTERPRENEUR_PAN_NO, KEY_CREATE_ENTERPRENEUR_PAN_NO);
        values.put(this.KEY_CREATE_ENTERPRENEUR_BANK_ACCOUNT_NO, KEY_CREATE_ENTERPRENEUR_BANK_ACCOUNT_NO);
        values.put(this.KEY_CREATE_ENTERPRENEUR_BANK_NAME, KEY_CREATE_ENTERPRENEUR_BANK_NAME);
        values.put(this.KEY_CREATE_ENTERPRENEUR_BRANCH_NAME, KEY_CREATE_ENTERPRENEUR_BRANCH_NAME);
        values.put(this.KEY_CREATE_ENTERPRENEUR_BANK_IFSC, KEY_CREATE_ENTERPRENEUR_BANK_IFSC);
        values.put(this.KEY_CREATE_ENTERPRENEUR_MARITAL_STATUS, KEY_CREATE_ENTERPRENEUR_MARITAL_STATUS);
        values.put(this.KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_CREATED, KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_CREATED);
        values.put(this.KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_SUBMITTED, KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_SUBMITTED);
        values.put(this.KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_IS_MODEL, KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_IS_MODEL);
        values.put(this.KEY_CREATE_ENTERPRENEUR_IS_ENTERPRISE_REGISTRED, KEY_CREATE_ENTERPRENEUR_IS_ENTERPRISE_REGISTRED);
        values.put(this.KEY_CREATE_ENTERPRENEUR_FULL_NAME, KEY_CREATE_ENTERPRENEUR_FULL_NAME);
        values.put(this.KEY_CREATE_ENTERPRENEUR_ENROLLMENT_DATE, KEY_CREATE_ENTERPRENEUR_ENROLLMENT_DATE);
        values.put(this.KEY_CREATE_ENTERPRENEUR_NO_OF_DEPENDENT, KEY_CREATE_ENTERPRENEUR_NO_OF_DEPENDENT);
        values.put(this.KEY_CREATE_ENTERPRENEUR_IS_JOIN_EVENT, KEY_CREATE_ENTERPRENEUR_IS_JOIN_EVENT);
        values.put(this.KEY_CREATE_ENTERPRENEUR_EVENT_NAME, KEY_CREATE_ENTERPRENEUR_EVENT_NAME);
        values.put(this.KEY_CREATE_ENTERPRENEUR_PARICIPANT_NAME, KEY_CREATE_ENTERPRENEUR_PARICIPANT_NAME);
        return mSqLiteDatabase.insert(TABLE_CREATE_ENTERPRENEUR, null, values);
    }
    //UPDATE ENTERPRENEUR DATA
    public int updateCreatedEnterpreneurData(Long KEY_CREATE_ENTERPRENEUR_ID,
                                             Long KEY_USER_ID,
                                             double KEY_LATITUDE,
                                             double KEY_LONGITUDE,
                                             String KEY_CREATE_ENTERPRENEUR_ENTERPRISE_TYPE,
                                             String KEY_CREATE_ENTERPRENEUR_ENTERPRISE_NAME,
                                             String KEY_CREATE_ENTERPRENEUR_TYPE_OF_ENTERPRISE,
                                             String KEY_CREATE_ENTERPRENEUR_DESCRIPTION,
                                             String KEY_CREATE_ENTERPRENEUR_FIRSTNAME,
                                             String KEY_CREATE_ENTERPRENEUR_MIDDLENAME,
                                             String KEY_CREATE_ENTERPRENEUR_LASTNAME,
                                             Long KEY_CREATE_ENTERPRENEUR_BIRTHDATE,
                                             String KEY_CREATE_ENTERPRENEUR_GENDER,
                                             String KEY_CREATE_ENTERPRENEUR_EMAILID,
                                             Long KEY_CREATE_ENTERPRENEUR_SOCIAL_CATEGORY,
                                             Long KEY_CREATE_ENTERPRENEUR_STATE,
                                             Long KEY_CREATE_ENTERPRENEUR_DISTRICT,
                                             Long KEY_CREATE_ENTERPRENEUR_BLOCK,
                                             Long KEY_CREATE_ENTERPRENEUR_VILLEGE,
                                             String KEY_CREATE_ENTERPRENEUR_RESIDENCE_ADDRESS,
                                             String KEY_CREATE_ENTERPRENEUR_PINCODE,
                                             String KEY_CREATE_ENTERPRENEUR_ADDHAR_NO,
                                             String KEY_CREATE_ENTERPRENEUR_PAN_NO,
                                             String KEY_CREATE_ENTERPRENEUR_BANK_ACCOUNT_NO,
                                             String KEY_CREATE_ENTERPRENEUR_BANK_NAME,
                                             String KEY_CREATE_ENTERPRENEUR_BRANCH_NAME,
                                             String KEY_CREATE_ENTERPRENEUR_BANK_IFSC,
                                             String KEY_CREATE_ENTERPRENEUR_MARITAL_STATUS,
                                             int KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_CREATED,
                                             int KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_SUBMITTED,
                                             int KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_IS_MODEL,
                                             int KEY_CREATE_ENTERPRENEUR_IS_ENTERPRISE_REGISTRED,
                                             String KEY_CREATE_ENTERPRENEUR_FULL_NAME,
                                             Long KEY_CREATE_ENTERPRENEUR_ENROLLMENT_DATE,
                                             int KEY_CREATE_ENTERPRENEUR_NO_OF_DEPENDENT,
                                             String KEY_CREATE_ENTERPRENEUR_IS_JOIN_EVENT,
                                             String KEY_CREATE_ENTERPRENEUR_EVENT_NAME,
                                             String KEY_CREATE_ENTERPRENEUR_PARICIPANT_NAME) {

        ContentValues values = new ContentValues();
        values.put(this.KEY_CREATE_ENTERPRENEUR_ID, KEY_CREATE_ENTERPRENEUR_ID);
        values.put(this.KEY_USER_ID, KEY_USER_ID);
        values.put(this.KEY_LATITUDE, KEY_LATITUDE);
        values.put(this.KEY_LONGITUDE, KEY_LONGITUDE);
        values.put(this.KEY_CREATE_ENTERPRENEUR_ENTERPRISE_TYPE, KEY_CREATE_ENTERPRENEUR_ENTERPRISE_TYPE);
        values.put(this.KEY_CREATE_ENTERPRENEUR_ENTERPRISE_NAME, KEY_CREATE_ENTERPRENEUR_ENTERPRISE_NAME);
        values.put(this.KEY_CREATE_ENTERPRENEUR_TYPE_OF_ENTERPRISE, KEY_CREATE_ENTERPRENEUR_TYPE_OF_ENTERPRISE);
        values.put(this.KEY_CREATE_ENTERPRENEUR_DESCRIPTION, KEY_CREATE_ENTERPRENEUR_DESCRIPTION);
        values.put(this.KEY_CREATE_ENTERPRENEUR_FIRSTNAME, KEY_CREATE_ENTERPRENEUR_FIRSTNAME);
        values.put(this.KEY_CREATE_ENTERPRENEUR_MIDDLENAME, KEY_CREATE_ENTERPRENEUR_MIDDLENAME);
        values.put(this.KEY_CREATE_ENTERPRENEUR_LASTNAME, KEY_CREATE_ENTERPRENEUR_LASTNAME);
        values.put(this.KEY_CREATE_ENTERPRENEUR_BIRTHDATE, KEY_CREATE_ENTERPRENEUR_BIRTHDATE);
        values.put(this.KEY_CREATE_ENTERPRENEUR_GENDER, KEY_CREATE_ENTERPRENEUR_GENDER);
        values.put(this.KEY_CREATE_ENTERPRENEUR_EMAILID, KEY_CREATE_ENTERPRENEUR_EMAILID);
        values.put(this.KEY_CREATE_ENTERPRENEUR_SOCIAL_CATEGORY, KEY_CREATE_ENTERPRENEUR_SOCIAL_CATEGORY);
        values.put(this.KEY_CREATE_ENTERPRENEUR_STATE, KEY_CREATE_ENTERPRENEUR_STATE);
        values.put(this.KEY_CREATE_ENTERPRENEUR_DISTRICT, KEY_CREATE_ENTERPRENEUR_DISTRICT);
        values.put(this.KEY_CREATE_ENTERPRENEUR_BLOCK, KEY_CREATE_ENTERPRENEUR_BLOCK);
        values.put(this.KEY_CREATE_ENTERPRENEUR_VILLEGE, KEY_CREATE_ENTERPRENEUR_VILLEGE);
        values.put(this.KEY_CREATE_ENTERPRENEUR_RESIDENCE_ADDRESS, KEY_CREATE_ENTERPRENEUR_RESIDENCE_ADDRESS);
        values.put(this.KEY_CREATE_ENTERPRENEUR_PINCODE, KEY_CREATE_ENTERPRENEUR_PINCODE);
        values.put(this.KEY_CREATE_ENTERPRENEUR_ADDHAR_NO, KEY_CREATE_ENTERPRENEUR_ADDHAR_NO);
        values.put(this.KEY_CREATE_ENTERPRENEUR_PAN_NO, KEY_CREATE_ENTERPRENEUR_PAN_NO);
        values.put(this.KEY_CREATE_ENTERPRENEUR_BANK_ACCOUNT_NO, KEY_CREATE_ENTERPRENEUR_BANK_ACCOUNT_NO);
        values.put(this.KEY_CREATE_ENTERPRENEUR_BANK_NAME, KEY_CREATE_ENTERPRENEUR_BANK_NAME);
        values.put(this.KEY_CREATE_ENTERPRENEUR_BRANCH_NAME, KEY_CREATE_ENTERPRENEUR_BRANCH_NAME);
        values.put(this.KEY_CREATE_ENTERPRENEUR_BANK_IFSC, KEY_CREATE_ENTERPRENEUR_BANK_IFSC);
        values.put(this.KEY_CREATE_ENTERPRENEUR_MARITAL_STATUS, KEY_CREATE_ENTERPRENEUR_MARITAL_STATUS);
        values.put(this.KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_CREATED, KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_CREATED);
        values.put(this.KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_SUBMITTED, KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_SUBMITTED);
        values.put(this.KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_IS_MODEL, KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_IS_MODEL);
        values.put(this.KEY_CREATE_ENTERPRENEUR_IS_ENTERPRISE_REGISTRED, KEY_CREATE_ENTERPRENEUR_IS_ENTERPRISE_REGISTRED);
        values.put(this.KEY_CREATE_ENTERPRENEUR_FULL_NAME, KEY_CREATE_ENTERPRENEUR_FULL_NAME);
        values.put(this.KEY_CREATE_ENTERPRENEUR_ENROLLMENT_DATE, KEY_CREATE_ENTERPRENEUR_ENROLLMENT_DATE);
        values.put(this.KEY_CREATE_ENTERPRENEUR_NO_OF_DEPENDENT, KEY_CREATE_ENTERPRENEUR_NO_OF_DEPENDENT);
        values.put(this.KEY_CREATE_ENTERPRENEUR_IS_JOIN_EVENT, KEY_CREATE_ENTERPRENEUR_IS_JOIN_EVENT);
        values.put(this.KEY_CREATE_ENTERPRENEUR_EVENT_NAME, KEY_CREATE_ENTERPRENEUR_EVENT_NAME);
        values.put(this.KEY_CREATE_ENTERPRENEUR_PARICIPANT_NAME, KEY_CREATE_ENTERPRENEUR_PARICIPANT_NAME);
        return mSqLiteDatabase.update(TABLE_CREATE_ENTERPRENEUR, values, this.KEY_CREATE_ENTERPRENEUR_ID + "=?", new String[]{String.valueOf(KEY_CREATE_ENTERPRENEUR_ID)});
    }

    //UPDATE ENTERPRENEUR BUSINESS PLAN CREATE STATUS
    public int updateEnterpreneurBusinessPlansCreattatus(Long enterpreneuerID, int intStatus) {
        ContentValues values = new ContentValues();
        values.put(KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_CREATED, intStatus);
        return mSqLiteDatabase.update(TABLE_CREATE_ENTERPRENEUR, values, this.KEY_CREATE_ENTERPRENEUR_ID + "=" + enterpreneuerID, null);

    }

    //UPDATE ENTERPRENEUR BUSINESS PLAN SUBMITT STATUS
    public int updateEnterpreneurBusinessPlansSubmittatus(Long enterpreneuerID, int intStatus) {
        ContentValues values = new ContentValues();
        values.put(KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_SUBMITTED, intStatus);
        return mSqLiteDatabase.update(TABLE_CREATE_ENTERPRENEUR, values, this.KEY_CREATE_ENTERPRENEUR_ID + "=" + enterpreneuerID, null);

    }

    //UPDATE ENTERPRENEUR BUSINESS PLAN SUBMITT STATUS
    public int updateEnterpreneurBusinessPlansIsModelStatuse(Long enterpreneuerID, int intStatus) {
        ContentValues values = new ContentValues();
        values.put(KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_IS_MODEL, intStatus);
        return mSqLiteDatabase.update(TABLE_CREATE_ENTERPRENEUR, values, this.KEY_CREATE_ENTERPRENEUR_ID + "=" + enterpreneuerID, null);

    }

    //UPDATE ENTERPRENEUR  ENTERPRISE IS REGISTERED
    public int updateEnterpreneureEnterpriseRegistrationStatus(Long enterpreneuerID, int intStatus) {
        ContentValues values = new ContentValues();
        values.put(KEY_CREATE_ENTERPRENEUR_IS_ENTERPRISE_REGISTRED, intStatus);
        return mSqLiteDatabase.update(TABLE_CREATE_ENTERPRENEUR, values, this.KEY_CREATE_ENTERPRENEUR_ID + "=" + enterpreneuerID, null);

    }

    //GET ALL ENTERPRENEUR DATA
    public ArrayList<CreateEnterpreneurModel.DataBean> getEnterpreneurList(Long enterpreneurID) {
        ArrayList<CreateEnterpreneurModel.DataBean> CreateEnterpreneurList = new ArrayList<>();
        result = null;

        try {

            //MAKE LIST AS PER REQUIRMENT
            //ENTERPRENEURID = 0 MEANS RETURN ALL RESULT
            //ENTERPRENEURID = 123456798 THEN RETURN SINGLE RECORD
            if (enterpreneurID == 0L) {
                result = mSqLiteDatabase.query(TABLE_CREATE_ENTERPRENEUR, new String[]{}, null, null,
                        null, null, null);
            } else {

                result = mSqLiteDatabase.query
                        (TABLE_CREATE_ENTERPRENEUR,
                                new String[]{
                                        this.KEY_ID,
                                        this.KEY_CREATE_ENTERPRENEUR_ID,
                                        this.KEY_USER_ID,
                                        this.KEY_LATITUDE,
                                        this.KEY_LONGITUDE,
                                        this.KEY_CREATE_ENTERPRENEUR_ENTERPRISE_TYPE,
                                        this.KEY_CREATE_ENTERPRENEUR_ENTERPRISE_NAME,
                                        this.KEY_CREATE_ENTERPRENEUR_TYPE_OF_ENTERPRISE,
                                        this.KEY_CREATE_ENTERPRENEUR_DESCRIPTION,
                                        this.KEY_CREATE_ENTERPRENEUR_FIRSTNAME,
                                        this.KEY_CREATE_ENTERPRENEUR_MIDDLENAME,
                                        this.KEY_CREATE_ENTERPRENEUR_LASTNAME,
                                        this.KEY_CREATE_ENTERPRENEUR_BIRTHDATE,
                                        this.KEY_CREATE_ENTERPRENEUR_GENDER,
                                        this.KEY_CREATE_ENTERPRENEUR_EMAILID,
                                        this.KEY_CREATE_ENTERPRENEUR_SOCIAL_CATEGORY,
                                        this.KEY_CREATE_ENTERPRENEUR_STATE,
                                        this.KEY_CREATE_ENTERPRENEUR_DISTRICT,
                                        this.KEY_CREATE_ENTERPRENEUR_BLOCK,
                                        this.KEY_CREATE_ENTERPRENEUR_VILLEGE,
                                        this.KEY_CREATE_ENTERPRENEUR_RESIDENCE_ADDRESS,
                                        this.KEY_CREATE_ENTERPRENEUR_PINCODE,
                                        this.KEY_CREATE_ENTERPRENEUR_ADDHAR_NO,
                                        this.KEY_CREATE_ENTERPRENEUR_PAN_NO,
                                        this.KEY_CREATE_ENTERPRENEUR_BANK_ACCOUNT_NO,
                                        this.KEY_CREATE_ENTERPRENEUR_BANK_NAME,
                                        this.KEY_CREATE_ENTERPRENEUR_BRANCH_NAME,
                                        this.KEY_CREATE_ENTERPRENEUR_BANK_IFSC,
                                        this.KEY_CREATE_ENTERPRENEUR_MARITAL_STATUS,
                                        this.KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_CREATED,
                                        this.KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_SUBMITTED,
                                        this.KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_IS_MODEL,
                                        this.KEY_CREATE_ENTERPRENEUR_IS_ENTERPRISE_REGISTRED,
                                        this.KEY_CREATE_ENTERPRENEUR_FULL_NAME,
                                        this.KEY_CREATE_ENTERPRENEUR_ENROLLMENT_DATE,
                                        this.KEY_CREATE_ENTERPRENEUR_NO_OF_DEPENDENT,
                                        this.KEY_CREATE_ENTERPRENEUR_IS_JOIN_EVENT,
                                        this.KEY_CREATE_ENTERPRENEUR_EVENT_NAME,
                                        this.KEY_CREATE_ENTERPRENEUR_PARICIPANT_NAME},

                                KEY_CREATE_ENTERPRENEUR_ID + "=" + enterpreneurID,
                                null, null, null, null, null
                        );

            }


            if (result.moveToFirst()) {
                do {
                    CreateEnterpreneurModel.DataBean mCreateEnterpreneurModel = new CreateEnterpreneurModel.DataBean();
                    mCreateEnterpreneurModel.setEnterpreneurID(result.getLong(1));
                    mCreateEnterpreneurModel.setUserID(result.getLong(2));
                    mCreateEnterpreneurModel.setLatitude(result.getDouble(3));
                    mCreateEnterpreneurModel.setLongitude(result.getDouble(4));
                    mCreateEnterpreneurModel.setEnterpriseType(result.getString(5));
                    mCreateEnterpreneurModel.setNameOfEntereprise(result.getString(6));
                    mCreateEnterpreneurModel.setTypeOfEnterprise(result.getString(7));
                    mCreateEnterpreneurModel.setDescription(result.getString(8));
                    mCreateEnterpreneurModel.setFirstName(result.getString(9));
                    mCreateEnterpreneurModel.setMiddleName(result.getString(10));
                    mCreateEnterpreneurModel.setLastName(result.getString(11));
                    mCreateEnterpreneurModel.setDateOfBirth(result.getLong(12));
                    mCreateEnterpreneurModel.setGender(result.getString(13));
                    mCreateEnterpreneurModel.setEmailID(result.getString(14));
                    mCreateEnterpreneurModel.setSocialCategoryID(result.getLong(15));
                    mCreateEnterpreneurModel.setStateID(result.getLong(16));
                    mCreateEnterpreneurModel.setDistrictID(result.getLong(17));
                    mCreateEnterpreneurModel.setBlockID(result.getLong(18));
                    mCreateEnterpreneurModel.setVillegeID(result.getLong(19));
                    mCreateEnterpreneurModel.setResidenceAddress(result.getString(20));
                    mCreateEnterpreneurModel.setPinCode(result.getString(21));
                    mCreateEnterpreneurModel.setAadharNo(result.getString(22));
                    mCreateEnterpreneurModel.setPanNo(result.getString(23));
                    mCreateEnterpreneurModel.setBankAccountNo(result.getString(24));
                    mCreateEnterpreneurModel.setBankName(result.getString(25));
                    mCreateEnterpreneurModel.setBranchName(result.getString(26));
                    mCreateEnterpreneurModel.setBankIFSCCode(result.getString(27));
                    mCreateEnterpreneurModel.setMaritalStatus(result.getString(28));
                    mCreateEnterpreneurModel.setIsBusinessPlanCreated(result.getInt(29));
                    mCreateEnterpreneurModel.setIsBusinessPlanSubmitted(result.getInt(30));
                    mCreateEnterpreneurModel.setIsModelBusinessPlan(result.getInt(31));
                    mCreateEnterpreneurModel.setIsEnterpriseRegistred(result.getInt(32));
                    mCreateEnterpreneurModel.setFullName(result.getString(33));
                    mCreateEnterpreneurModel.setEnrollmentDate(result.getLong(34));
                    mCreateEnterpreneurModel.setNoOfDependent(result.getInt(35));
                    mCreateEnterpreneurModel.setIsEventeAttained(result.getString(36));
                    mCreateEnterpreneurModel.setEventName(result.getString(37));
                    mCreateEnterpreneurModel.setParicipantName(result.getString(38));
                    CreateEnterpreneurList.add(mCreateEnterpreneurModel);


                    /*//SET COLLECTION LIST AS PER ABCD COUNT
                    Collections.sort(CreateEnterpreneurList, new Comparator<CreateEnterpreneurModel.DataBean>() {
                        public int compare(CreateEnterpreneurModel.DataBean v1, CreateEnterpreneurModel.DataBean v2) {
                            return v1.getFirstName().compareTo(v2.getFirstName());
                        }
                    });*/


                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return CreateEnterpreneurList;

    }

    //GET ALL ENTERPRENEUR DATA
    public ArrayList<CreateEnterpreneurModel.DataBean> getEnterpreneurListByVillageID(Long villageID) {
        ArrayList<CreateEnterpreneurModel.DataBean> CreateEnterpreneurList = new ArrayList<>();
        result = null;

        try {


                result = mSqLiteDatabase.query
                        (TABLE_CREATE_ENTERPRENEUR,
                                new String[]{
                                        this.KEY_ID,
                                        this.KEY_CREATE_ENTERPRENEUR_ID,
                                        this.KEY_USER_ID,
                                        this.KEY_LATITUDE,
                                        this.KEY_LONGITUDE,
                                        this.KEY_CREATE_ENTERPRENEUR_ENTERPRISE_TYPE,
                                        this.KEY_CREATE_ENTERPRENEUR_ENTERPRISE_NAME,
                                        this.KEY_CREATE_ENTERPRENEUR_TYPE_OF_ENTERPRISE,
                                        this.KEY_CREATE_ENTERPRENEUR_DESCRIPTION,
                                        this.KEY_CREATE_ENTERPRENEUR_FIRSTNAME,
                                        this.KEY_CREATE_ENTERPRENEUR_MIDDLENAME,
                                        this.KEY_CREATE_ENTERPRENEUR_LASTNAME,
                                        this.KEY_CREATE_ENTERPRENEUR_BIRTHDATE,
                                        this.KEY_CREATE_ENTERPRENEUR_GENDER,
                                        this.KEY_CREATE_ENTERPRENEUR_EMAILID,
                                        this.KEY_CREATE_ENTERPRENEUR_SOCIAL_CATEGORY,
                                        this.KEY_CREATE_ENTERPRENEUR_STATE,
                                        this.KEY_CREATE_ENTERPRENEUR_DISTRICT,
                                        this.KEY_CREATE_ENTERPRENEUR_BLOCK,
                                        this.KEY_CREATE_ENTERPRENEUR_VILLEGE,
                                        this.KEY_CREATE_ENTERPRENEUR_RESIDENCE_ADDRESS,
                                        this.KEY_CREATE_ENTERPRENEUR_PINCODE,
                                        this.KEY_CREATE_ENTERPRENEUR_ADDHAR_NO,
                                        this.KEY_CREATE_ENTERPRENEUR_PAN_NO,
                                        this.KEY_CREATE_ENTERPRENEUR_BANK_ACCOUNT_NO,
                                        this.KEY_CREATE_ENTERPRENEUR_BANK_NAME,
                                        this.KEY_CREATE_ENTERPRENEUR_BRANCH_NAME,
                                        this.KEY_CREATE_ENTERPRENEUR_BANK_IFSC,
                                        this.KEY_CREATE_ENTERPRENEUR_MARITAL_STATUS,
                                        this.KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_CREATED,
                                        this.KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_SUBMITTED,
                                        this.KEY_CREATE_ENTERPRENEUR_IS_BUSINESS_PLAN_IS_MODEL,
                                        this.KEY_CREATE_ENTERPRENEUR_IS_ENTERPRISE_REGISTRED,
                                        this.KEY_CREATE_ENTERPRENEUR_FULL_NAME,
                                        this.KEY_CREATE_ENTERPRENEUR_ENROLLMENT_DATE,
                                        this.KEY_CREATE_ENTERPRENEUR_NO_OF_DEPENDENT,
                                        this.KEY_CREATE_ENTERPRENEUR_IS_JOIN_EVENT,
                                        this.KEY_CREATE_ENTERPRENEUR_EVENT_NAME,
                                        this.KEY_CREATE_ENTERPRENEUR_PARICIPANT_NAME},
                                KEY_CREATE_ENTERPRENEUR_VILLEGE + "=" + villageID,
                                null, null, null, null, null
                        );


            if (result.moveToFirst()) {
                do {
                    CreateEnterpreneurModel.DataBean mCreateEnterpreneurModel = new CreateEnterpreneurModel.DataBean();
                    mCreateEnterpreneurModel.setEnterpreneurID(result.getLong(1));
                    mCreateEnterpreneurModel.setUserID(result.getLong(2));
                    mCreateEnterpreneurModel.setLatitude(result.getDouble(3));
                    mCreateEnterpreneurModel.setLongitude(result.getDouble(4));
                    mCreateEnterpreneurModel.setEnterpriseType(result.getString(5));
                    mCreateEnterpreneurModel.setNameOfEntereprise(result.getString(6));
                    mCreateEnterpreneurModel.setTypeOfEnterprise(result.getString(7));
                    mCreateEnterpreneurModel.setDescription(result.getString(8));
                    mCreateEnterpreneurModel.setFirstName(result.getString(9));
                    mCreateEnterpreneurModel.setMiddleName(result.getString(10));
                    mCreateEnterpreneurModel.setLastName(result.getString(11));
                    mCreateEnterpreneurModel.setDateOfBirth(result.getLong(12));
                    mCreateEnterpreneurModel.setGender(result.getString(13));
                    mCreateEnterpreneurModel.setEmailID(result.getString(14));
                    mCreateEnterpreneurModel.setSocialCategoryID(result.getLong(15));
                    mCreateEnterpreneurModel.setStateID(result.getLong(16));
                    mCreateEnterpreneurModel.setDistrictID(result.getLong(17));
                    mCreateEnterpreneurModel.setBlockID(result.getLong(18));
                    mCreateEnterpreneurModel.setVillegeID(result.getLong(19));
                    mCreateEnterpreneurModel.setResidenceAddress(result.getString(20));
                    mCreateEnterpreneurModel.setPinCode(result.getString(21));
                    mCreateEnterpreneurModel.setAadharNo(result.getString(22));
                    mCreateEnterpreneurModel.setPanNo(result.getString(23));
                    mCreateEnterpreneurModel.setBankAccountNo(result.getString(24));
                    mCreateEnterpreneurModel.setBankName(result.getString(25));
                    mCreateEnterpreneurModel.setBranchName(result.getString(26));
                    mCreateEnterpreneurModel.setBankIFSCCode(result.getString(27));
                    mCreateEnterpreneurModel.setMaritalStatus(result.getString(28));
                    mCreateEnterpreneurModel.setIsBusinessPlanCreated(result.getInt(29));
                    mCreateEnterpreneurModel.setIsBusinessPlanSubmitted(result.getInt(30));
                    mCreateEnterpreneurModel.setIsModelBusinessPlan(result.getInt(31));
                    mCreateEnterpreneurModel.setIsEnterpriseRegistred(result.getInt(32));
                    mCreateEnterpreneurModel.setFullName(result.getString(33));
                    mCreateEnterpreneurModel.setEnrollmentDate(result.getLong(34));
                    mCreateEnterpreneurModel.setNoOfDependent(result.getInt(35));
                    mCreateEnterpreneurModel.setIsEventeAttained(result.getString(36));
                    mCreateEnterpreneurModel.setEventName(result.getString(37));
                    mCreateEnterpreneurModel.setParicipantName(result.getString(38));
                    CreateEnterpreneurList.add(mCreateEnterpreneurModel);


                    //SET COLLECTION LIST AS PER ABCD COUNT
                    Collections.sort(CreateEnterpreneurList, new Comparator<CreateEnterpreneurModel.DataBean>() {
                        public int compare(CreateEnterpreneurModel.DataBean v1, CreateEnterpreneurModel.DataBean v2) {
                            return v1.getFirstName().compareTo(v2.getFirstName());
                        }
                    });


                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return CreateEnterpreneurList;

    }


    //INSERT, UPDATE AND DELETE ENTERPRENEUR'S EDUCATION AND WORK PROFILE DATA
    public Long insertEdicationQualificationList(Long createdBy, Long modifiedBy, Long createdDate, Long id, String qualificationName,
                                                 String universityName, String passingYear, String majorSubject, Long entrepreneurId, int deleted) {


        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_CREATED_BY_GET, createdBy);
        values.put(KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_MODIFIED_BY_GET, modifiedBy);
        values.put(KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_CREATED_DATE_GET, createdDate);
        values.put(KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_ID_GET, id);
        values.put(KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_QUALIFICATION_NAME_GET, qualificationName);
        values.put(KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_UNIVERSITY_NAME_GET, universityName);
        values.put(KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_PASSING_YEAR_GET, passingYear);
        values.put(KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_MAJOR_SUBJECT_GET, majorSubject);
        values.put(KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_ENTREPRENEUR_ID_GET, entrepreneurId);
        values.put(KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_DELETED_GET, deleted);

        return mSqLiteDatabase.insert(TABLE_ENTREPRENUR_EDUCATION_QUALIFICATION_LIST, null, values);
    }

    public int updateEducationData(Long createdBy, Long modifiedBy, Long createdDate, Long id, String qualificationName,
                                   String universityName, String passingYear, String majorSubject, Long entrepreneurId, int deleted) {


        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_CREATED_BY_GET, createdBy);
        values.put(KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_MODIFIED_BY_GET, modifiedBy);
        values.put(KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_CREATED_DATE_GET, createdDate);
        values.put(KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_ID_GET, id);
        values.put(KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_QUALIFICATION_NAME_GET, qualificationName);
        values.put(KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_UNIVERSITY_NAME_GET, universityName);
        values.put(KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_PASSING_YEAR_GET, passingYear);
        values.put(KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_MAJOR_SUBJECT_GET, majorSubject);
        values.put(KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_ENTREPRENEUR_ID_GET, entrepreneurId);
        values.put(KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_DELETED_GET, deleted);

        // return mSqLiteDatabase.insert(TABLE_ENTREPRENUR_EDUCATION_QUALIFICATION_LIST, null, values);
        return mSqLiteDatabase.update(TABLE_ENTREPRENUR_EDUCATION_QUALIFICATION_LIST, values, this.KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_ID_GET + "=" + id, null);
    }


    public ArrayList<CreateEnterpreneurModel.ListEducationalQualificationBean> getAllEntrepreneurEducationQualificationList(Long id) {
        ArrayList<CreateEnterpreneurModel.ListEducationalQualificationBean> mEntrepreneurEducationQualificationListBean = new ArrayList<>();

        try {

            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENUR_EDUCATION_QUALIFICATION_LIST,
                            new String[]{
                                    KEY_ID,
                                    KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_CREATED_BY_GET,
                                    KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_MODIFIED_BY_GET,
                                    KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_CREATED_DATE_GET,
                                    KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_ID_GET,
                                    KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_QUALIFICATION_NAME_GET,
                                    KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_UNIVERSITY_NAME_GET,
                                    KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_PASSING_YEAR_GET,
                                    KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_MAJOR_SUBJECT_GET,
                                    KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_ENTREPRENEUR_ID_GET,
                                    KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_DELETED_GET},

                            KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_ENTREPRENEUR_ID_GET + "=" + id,
                            null, null, null, null, null
                    );

            if (result.moveToFirst()) {
                do {
                    CreateEnterpreneurModel.ListEducationalQualificationBean mEducationQualificationListModel = new CreateEnterpreneurModel.ListEducationalQualificationBean();
                    mEducationQualificationListModel.setCreatedBy(result.getLong(1));
                    mEducationQualificationListModel.setModifiedBy(result.getLong(2));
                    mEducationQualificationListModel.setCreatedDate(result.getLong(3));
                    mEducationQualificationListModel.setId(result.getLong(4));
                    mEducationQualificationListModel.setQualificationName(result.getString(5));
                    mEducationQualificationListModel.setUniversityName(result.getString(6));
                    mEducationQualificationListModel.setPassingYear(result.getString(7));
                    mEducationQualificationListModel.setMajorSubject(result.getString(8));
                    mEducationQualificationListModel.setEntrepreneurId(result.getLong(9));
                    if (result.getInt(10) == 1) {
                        mEducationQualificationListModel.setDeleted(true);
                    } else {
                        mEducationQualificationListModel.setDeleted(false);
                    }
                    mEntrepreneurEducationQualificationListBean.add(mEducationQualificationListModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }
        return mEntrepreneurEducationQualificationListBean;
    }

    //----------(delete Entrepreneur list of Education Qualifications)------------//
    public long deleteEdicationQualificationSellDatabyID(Long itemID) {
        return mSqLiteDatabase.delete(TABLE_ENTREPRENUR_EDUCATION_QUALIFICATION_LIST, KEY_ENTREPRENEUR_EDU_QUAL_DETAILS_ID_GET + "= ?", new String[]{"" + itemID});
    }

    //METHODS FOR SPECIAL TRAINING DETIALS

    //----------(delete Entrepreneur list of Special Training by item id)------------//
    public long deleteSpecialTrainingByID(Long Id) {

        return mSqLiteDatabase.delete(TABLE_ENTREPRENUR_SPECIAL_TRAINING_LIST, KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_ID_GET + "= ?", new String[]{"" + Id});
    }

    //-------(Insert and get list of Special Training)------------//
    public Long insertSpecialTrainingList(Long id, String subject, String institute, String duration, String learning, Long entrepreneurId) {


        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_ID_GET, id);
        values.put(KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_SUBJECT_GET, subject);
        values.put(KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_INSTITUTE_GET, institute);
        values.put(KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_DURATION_GET, duration);
        values.put(KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_LEARNING_GET, learning);
        values.put(KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_RNTREPRENEUR_ID_GET, entrepreneurId);

        return mSqLiteDatabase.insert(TABLE_ENTREPRENUR_SPECIAL_TRAINING_LIST, null, values);
    }

    //-------(Insert and get list of Special Training)------------//
    public int updateSpecialTrainingList(Long id, String subject, String institute, String duration, String learning, Long entrepreneurId) {


        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_ID_GET, id);
        values.put(KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_SUBJECT_GET, subject);
        values.put(KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_INSTITUTE_GET, institute);
        values.put(KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_DURATION_GET, duration);
        values.put(KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_LEARNING_GET, learning);
        values.put(KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_RNTREPRENEUR_ID_GET, entrepreneurId);

        //return mSqLiteDatabase.insert(TABLE_ENTREPRENUR_SPECIAL_TRAINING_LIST, null, values);
        return mSqLiteDatabase.update(TABLE_ENTREPRENUR_SPECIAL_TRAINING_LIST, values, this.KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_ID_GET + "=" + id, null);

    }


    public ArrayList<CreateEnterpreneurModel.ListSpecialTrainingBean> getAllEntrepreneurSpecialTrainingList(Long id) {
        ArrayList<CreateEnterpreneurModel.ListSpecialTrainingBean> mEntrepreneurSpecialTrainingListBean = new ArrayList<>();

        try {

            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENUR_SPECIAL_TRAINING_LIST,
                            new String[]{
                                    KEY_ID,
                                    KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_ID_GET,
                                    KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_SUBJECT_GET,
                                    KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_INSTITUTE_GET,
                                    KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_DURATION_GET,
                                    KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_LEARNING_GET,
                                    KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_RNTREPRENEUR_ID_GET},

                            KEY_ENTREPRENEUR_SPECIAL_TRAINING_DETAILS_RNTREPRENEUR_ID_GET + "=" + id,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {
                do {
                    CreateEnterpreneurModel.ListSpecialTrainingBean mSpecialTrainingListModel = new CreateEnterpreneurModel.ListSpecialTrainingBean();
                    mSpecialTrainingListModel.setId(result.getLong(1));
                    mSpecialTrainingListModel.setSubject(result.getString(2));
                    mSpecialTrainingListModel.setInstitute(result.getString(3));
                    mSpecialTrainingListModel.setDuration(result.getString(4));
                    mSpecialTrainingListModel.setLearning(result.getString(5));
                    mSpecialTrainingListModel.setEntrepreneurId(result.getLong(6));


                    mEntrepreneurSpecialTrainingListBean.add(mSpecialTrainingListModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }
        return mEntrepreneurSpecialTrainingListBean;
    }

    //INSERT, UPDATE AND DELETE FOR WORK EXPERIENCE
    //----------(delete Entrepreneur list of Work Experience by item id)------------//
    public long deleteWorkExperienceByItemID(Long Id) {

        return mSqLiteDatabase.delete(TABLE_ENTREPRENUR_WORK_EXPERIENCE_LIST, KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_ID_GET + "= ?", new String[]{"" + Id});
    }


    //-------(Insert and get list of Work Experience)------------//
    public Long insertWorkExperienceList(Long id, String organisation, String designation, String jobProfile, String duration, Long entrepreneurId) {


        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_ID_GET, id);
        values.put(KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_ORGANISATION_GET, organisation);
        values.put(KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_DESIGNATION_GET, designation);
        values.put(KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_JOB_PROFILE_GET, jobProfile);
        values.put(KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_DURATION_GET, duration);
        values.put(KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_ENTREPRENEUR_ID_GET, entrepreneurId);

        return mSqLiteDatabase.insert(TABLE_ENTREPRENUR_WORK_EXPERIENCE_LIST, null, values);
    }


    //-------(Update Work Experience)------------//
    public int updateWorkExperienceList(Long id, String organisation, String designation, String jobProfile, String duration, Long entrepreneurId) {


        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_ID_GET, id);
        values.put(KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_ORGANISATION_GET, organisation);
        values.put(KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_DESIGNATION_GET, designation);
        values.put(KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_JOB_PROFILE_GET, jobProfile);
        values.put(KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_DURATION_GET, duration);
        values.put(KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_ENTREPRENEUR_ID_GET, entrepreneurId);

        // return mSqLiteDatabase.insert(TABLE_ENTREPRENUR_WORK_EXPERIENCE_LIST, null, values);
        return mSqLiteDatabase.update(TABLE_ENTREPRENUR_WORK_EXPERIENCE_LIST, values, this.KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_ID_GET + "=" + id, null);

    }


    public ArrayList<CreateEnterpreneurModel.ListWorkExperienceBean> getAllEntrepreneurWorkExperienceList(Long id) {
        ArrayList<CreateEnterpreneurModel.ListWorkExperienceBean> mEntrepreneurWorkExperienceListBean = new ArrayList<>();

        try {

            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENUR_WORK_EXPERIENCE_LIST,
                            new String[]{
                                    KEY_ID,
                                    KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_ID_GET,
                                    KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_ORGANISATION_GET,
                                    KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_DESIGNATION_GET,
                                    KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_JOB_PROFILE_GET,
                                    KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_DURATION_GET,
                                    KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_ENTREPRENEUR_ID_GET},

                            KEY_ENTREPRENEUR_WORK_EXPERIENCE_DETAILS_ENTREPRENEUR_ID_GET + "=" + id,
                            null, null, null, null, null
                    );

            if (result.moveToFirst()) {
                do {
                    CreateEnterpreneurModel.ListWorkExperienceBean mWorkExperienceListModel = new CreateEnterpreneurModel.ListWorkExperienceBean();
                    mWorkExperienceListModel.setId(result.getLong(1));
                    mWorkExperienceListModel.setOrganisation(result.getString(2));
                    mWorkExperienceListModel.setDesignation(result.getString(3));
                    mWorkExperienceListModel.setJobProfile(result.getString(4));
                    mWorkExperienceListModel.setDuration(result.getString(5));
                    mWorkExperienceListModel.setEntrepreneurId(result.getLong(6));

                    mEntrepreneurWorkExperienceListBean.add(mWorkExperienceListModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }
        return mEntrepreneurWorkExperienceListBean;
    }

    //SAVE ALL EDUCATION, SPECIAL TRAINING AND WORK EXPERIENCE DATA IN TO DATABASE WHICH WE WILL USE IT FOR SYNC TO WEB
    //----------(delete Entrepreneur Education & Job Details)------------//
    public long deleteEntrepreneurEduJobRegistration(Long entrepreneurId) {

        ///return mSqLiteDatabase.delete(TABLE_ENTREPRENEUR_EDU_JOB_DETAILS, KEY_ENTREPRENEUR_EDU_JOB_ENTREPRENEUR_ID + "= ?", new String[] {""+entrepreneurId});
        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_EDU_JOB_ENTREPRENEUR_ID, entrepreneurId);
        String whereArgs[] = new String[1];
        whereArgs[0] = "" + entrepreneurId;
        return mSqLiteDatabase.delete(TABLE_ENTREPRENEUR_EDU_JOB_DETAILS, KEY_ENTREPRENEUR_EDU_JOB_ENTREPRENEUR_ID + "= ?", whereArgs);
    }

    //----------(Insert and get Entrepreneur Education & Job Details)------------//
    public long insertEntrepreneurEduJobRegistration(Long entrepreneurId, String educationQualificationModelArrayList, String specialTrainingModelArrayList, String workExperienceModelArrayList) {

        ContentValues values = new ContentValues();

        values.put(KEY_ENTREPRENEUR_EDU_JOB_ENTREPRENEUR_ID, entrepreneurId);
        values.put(KEY_ENTREPRENEUR_EDU_JOB_EDUCATION, educationQualificationModelArrayList);
        values.put(KEY_ENTREPRENEUR_EDU_JOB_SPECIAL_TRAINING, specialTrainingModelArrayList);
        values.put(KEY_ENTREPRENEUR_EDU_JOB_EORK_EXPERIENCE, workExperienceModelArrayList);

        return mSqLiteDatabase.insert(TABLE_ENTREPRENEUR_EDU_JOB_DETAILS, null, values);
    }

    public ArrayList<EducationJobProfileDTO> getEntrepreneurEduJobDetails() {
        ArrayList<EducationJobProfileDTO> mEntrepreneurEduJobDetailsModelList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query(TABLE_ENTREPRENEUR_EDU_JOB_DETAILS, new String[]{}, null, null,
                    null, null, null);

            if (result.moveToFirst()) {
                do {

                    EducationJobProfileDTO educationJobProfileDTO = new EducationJobProfileDTO();
                    educationJobProfileDTO.setEntrepreneurId(result.getLong(1));

                    Gson gson = new Gson();
                    Gson gson1 = new Gson();
                    Gson gson2 = new Gson();

                    String strEducationQualificationModelArrayList = result.getString(2);
                    TypeToken<ArrayList<EducationQualificationModel>> token = new TypeToken<ArrayList<EducationQualificationModel>>() {
                    };
                    ArrayList<EducationQualificationModel> arrayListEducation = gson.fromJson(strEducationQualificationModelArrayList, token.getType());
                    educationJobProfileDTO.setEducationalQualifications(arrayListEducation);

                    String strspecialTrainingModelArrayList = result.getString(3);
                    TypeToken<ArrayList<SpecialTrainingModel>> Stoken = new TypeToken<ArrayList<SpecialTrainingModel>>() {
                    };
                    ArrayList<SpecialTrainingModel> arrayListSpecialTrainig = gson1.fromJson(strspecialTrainingModelArrayList, Stoken.getType());
                    educationJobProfileDTO.setSpecialTrainings(arrayListSpecialTrainig);

                    String strWorkExperienceModelArrayList = result.getString(4);
                    TypeToken<ArrayList<WorkExperienceModel>> Wtoken = new TypeToken<ArrayList<WorkExperienceModel>>() {
                    };
                    ArrayList<WorkExperienceModel> arrayListWorkExperience = gson2.fromJson(strWorkExperienceModelArrayList, Wtoken.getType());
                    educationJobProfileDTO.setWorkExperiences(arrayListWorkExperience);

                    mEntrepreneurEduJobDetailsModelList.add(educationJobProfileDTO);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurEduJobDetailsModelList;


    }

    public ArrayList<EducationJobProfileDTO> getEntrepreneurEduJobDetailsForEnterprenuer(Long EnterprenuerID) {
        ArrayList<EducationJobProfileDTO> mEntrepreneurEduJobDetailsModelList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENEUR_EDU_JOB_DETAILS,
                            new String[]{
                                    KEY_ID,
                                    KEY_ENTREPRENEUR_EDU_JOB_ENTREPRENEUR_ID,
                                    KEY_ENTREPRENEUR_EDU_JOB_EDUCATION,
                                    KEY_ENTREPRENEUR_EDU_JOB_SPECIAL_TRAINING,
                                    KEY_ENTREPRENEUR_EDU_JOB_EORK_EXPERIENCE
                            },
                            KEY_ENTREPRENEUR_EDU_JOB_ENTREPRENEUR_ID + "=" + EnterprenuerID,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {
                do {

                    EducationJobProfileDTO educationJobProfileDTO = new EducationJobProfileDTO();
                    educationJobProfileDTO.setEntrepreneurId(result.getLong(1));

                    Gson gson = new Gson();
                    Gson gson1 = new Gson();
                    Gson gson2 = new Gson();

                    String strEducationQualificationModelArrayList = result.getString(2);
                    TypeToken<ArrayList<EducationQualificationModel>> token = new TypeToken<ArrayList<EducationQualificationModel>>() {
                    };
                    ArrayList<EducationQualificationModel> arrayListEducation = gson.fromJson(strEducationQualificationModelArrayList, token.getType());
                    educationJobProfileDTO.setEducationalQualifications(arrayListEducation);

                    String strspecialTrainingModelArrayList = result.getString(3);
                    TypeToken<ArrayList<SpecialTrainingModel>> Stoken = new TypeToken<ArrayList<SpecialTrainingModel>>() {
                    };
                    ArrayList<SpecialTrainingModel> arrayListSpecialTrainig = gson1.fromJson(strspecialTrainingModelArrayList, Stoken.getType());
                    educationJobProfileDTO.setSpecialTrainings(arrayListSpecialTrainig);

                    String strWorkExperienceModelArrayList = result.getString(4);
                    TypeToken<ArrayList<WorkExperienceModel>> Wtoken = new TypeToken<ArrayList<WorkExperienceModel>>() {
                    };
                    ArrayList<WorkExperienceModel> arrayListWorkExperience = gson2.fromJson(strWorkExperienceModelArrayList, Wtoken.getType());
                    educationJobProfileDTO.setWorkExperiences(arrayListWorkExperience);

                    mEntrepreneurEduJobDetailsModelList.add(educationJobProfileDTO);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurEduJobDetailsModelList;


    }


    //INSERT, UPDATE , DELETE TRAINING DETAILS DATA
    public long insertTrainingDetails(Long KEY_ENTREPRENEUR_TRAINING_ID_PK,
                                      Long KEY_ENTREPRENEUR_TRAINING_ENTREPRENEUR_ID,
                                      Long KEY_ENTREPRENEUR_TRAINING_CREATED_DATE,
                                      Long KEY_ENTREPRENEUR_TRAINING_CREATED_BY,
                                      Double KEY_ENTREPRENEUR_TRAINING_LATITUDE,
                                      Double KEY_ENTREPRENEUR_TRAINING_LONGITUDE,
                                      String KEY_ENTREPRENEUR_TRAINING_NAME,
                                      Long KEY_ENTREPRENEUR_TRAINING_START_DATE,
                                      Long KEY_ENTREPRENEUR_TRAINING_END_DATE,
                                      String KEY_ENTREPRENEUR_TRAINING_DESCRIPTION) {
        ContentValues values = new ContentValues();
        values.put(this.KEY_ENTREPRENEUR_TRAINING_ID_PK, KEY_ENTREPRENEUR_TRAINING_ID_PK);
        values.put(this.KEY_ENTREPRENEUR_TRAINING_ENTREPRENEUR_ID, KEY_ENTREPRENEUR_TRAINING_ENTREPRENEUR_ID);
        values.put(this.KEY_ENTREPRENEUR_TRAINING_CREATED_DATE, KEY_ENTREPRENEUR_TRAINING_CREATED_DATE);
        values.put(this.KEY_ENTREPRENEUR_TRAINING_CREATED_BY, KEY_ENTREPRENEUR_TRAINING_CREATED_BY);
        values.put(this.KEY_ENTREPRENEUR_TRAINING_LATITUDE, KEY_ENTREPRENEUR_TRAINING_LATITUDE);
        values.put(this.KEY_ENTREPRENEUR_TRAINING_LONGITUDE, KEY_ENTREPRENEUR_TRAINING_LONGITUDE);
        values.put(this.KEY_ENTREPRENEUR_TRAINING_NAME, KEY_ENTREPRENEUR_TRAINING_NAME);
        values.put(this.KEY_ENTREPRENEUR_TRAINING_START_DATE, KEY_ENTREPRENEUR_TRAINING_START_DATE);
        values.put(this.KEY_ENTREPRENEUR_TRAINING_END_DATE, KEY_ENTREPRENEUR_TRAINING_END_DATE);
        values.put(this.KEY_ENTREPRENEUR_TRAINING_DESCRIPTION, KEY_ENTREPRENEUR_TRAINING_DESCRIPTION);

        return mSqLiteDatabase.insert(TABLE_ENTREPRENEUR_TRAINING, null, values);
    }

    //---- update training details ---//
    public int updateTrainingDetails(Long KEY_ENTREPRENEUR_TRAINING_ID_PK,
                                     Long KEY_ENTREPRENEUR_TRAINING_ENTREPRENEUR_ID,
                                     Long KEY_ENTREPRENEUR_TRAINING_CREATED_DATE,
                                     Long KEY_ENTREPRENEUR_TRAINING_CREATED_BY,
                                     Double KEY_ENTREPRENEUR_TRAINING_LATITUDE,
                                     Double KEY_ENTREPRENEUR_TRAINING_LONGITUDE,
                                     String KEY_ENTREPRENEUR_TRAINING_NAME,
                                     Long KEY_ENTREPRENEUR_TRAINING_START_DATE,
                                     Long KEY_ENTREPRENEUR_TRAINING_END_DATE,
                                     String KEY_ENTREPRENEUR_TRAINING_DESCRIPTION) {
        ContentValues values = new ContentValues();
        values.put(this.KEY_ENTREPRENEUR_TRAINING_ID_PK, KEY_ENTREPRENEUR_TRAINING_ID_PK);
        values.put(this.KEY_ENTREPRENEUR_TRAINING_ENTREPRENEUR_ID, KEY_ENTREPRENEUR_TRAINING_ENTREPRENEUR_ID);
        values.put(this.KEY_ENTREPRENEUR_TRAINING_CREATED_DATE, KEY_ENTREPRENEUR_TRAINING_CREATED_DATE);
        values.put(this.KEY_ENTREPRENEUR_TRAINING_CREATED_BY, KEY_ENTREPRENEUR_TRAINING_CREATED_BY);
        values.put(this.KEY_ENTREPRENEUR_TRAINING_LATITUDE, KEY_ENTREPRENEUR_TRAINING_LATITUDE);
        values.put(this.KEY_ENTREPRENEUR_TRAINING_LONGITUDE, KEY_ENTREPRENEUR_TRAINING_LONGITUDE);
        values.put(this.KEY_ENTREPRENEUR_TRAINING_NAME, KEY_ENTREPRENEUR_TRAINING_NAME);
        values.put(this.KEY_ENTREPRENEUR_TRAINING_START_DATE, KEY_ENTREPRENEUR_TRAINING_START_DATE);
        values.put(this.KEY_ENTREPRENEUR_TRAINING_END_DATE, KEY_ENTREPRENEUR_TRAINING_END_DATE);
        values.put(this.KEY_ENTREPRENEUR_TRAINING_DESCRIPTION, KEY_ENTREPRENEUR_TRAINING_DESCRIPTION);

        return mSqLiteDatabase.update(TABLE_ENTREPRENEUR_TRAINING, values,
                this.KEY_ENTREPRENEUR_TRAINING_ID_PK + "=?", new String[]{String.valueOf(KEY_ENTREPRENEUR_TRAINING_ID_PK)});
    }

    //--- get training details by entreprenuer id ---/
    public ArrayList<EnterpreneurTrainingDetailsModel.DataBean> getTrainingDetailsByEntreprenuerId(String EntreprenuerID) {
        ArrayList<EnterpreneurTrainingDetailsModel.DataBean> trainingDetailsList = new ArrayList<>();
        try {
            result = mSqLiteDatabase.query(TABLE_ENTREPRENEUR_TRAINING,
                    new String[]{KEY_ENTREPRENEUR_TRAINING_ID_PK,
                            KEY_ENTREPRENEUR_TRAINING_ENTREPRENEUR_ID,
                            KEY_ENTREPRENEUR_TRAINING_NAME,
                            KEY_ENTREPRENEUR_TRAINING_START_DATE,
                            KEY_ENTREPRENEUR_TRAINING_END_DATE,
                            KEY_ENTREPRENEUR_TRAINING_DESCRIPTION},
                    KEY_ENTREPRENEUR_TRAINING_ENTREPRENEUR_ID + "=?", new String[]{EntreprenuerID},
                    null, null, null, null);
            if (result.moveToFirst()) {
                do {

                    EnterpreneurTrainingDetailsModel.DataBean trainingDetails = new EnterpreneurTrainingDetailsModel.DataBean();
                    trainingDetails.setId(result.getLong(0));
                    trainingDetails.setEntrepreneurId(result.getLong(1));
                    trainingDetails.setTrainingName(result.getString(2));
                    trainingDetails.setTrainingStartDate(result.getLong(3));
                    trainingDetails.setTrainingEndDate(result.getLong(4));
                    trainingDetails.setTrainingDescription(result.getString(5));
                    trainingDetailsList.add(trainingDetails);
                } while (result.moveToNext());
            }
        } catch (Exception e) {

        }

        return trainingDetailsList;


    }


    public ArrayList<EnterpreneurTrainingDetailsModel.DataBean> getAllTrainingDetails() {
        ArrayList<EnterpreneurTrainingDetailsModel.DataBean> TrainingList = new ArrayList<>();

        try {

            result = mSqLiteDatabase.query(TABLE_ENTREPRENEUR_TRAINING,
                    new String[]{KEY_ENTREPRENEUR_TRAINING_ID_PK,
                            KEY_ENTREPRENEUR_TRAINING_ENTREPRENEUR_ID,
                            KEY_ENTREPRENEUR_TRAINING_CREATED_DATE,
                            KEY_ENTREPRENEUR_TRAINING_CREATED_BY,
                            KEY_ENTREPRENEUR_TRAINING_LATITUDE,
                            KEY_ENTREPRENEUR_TRAINING_LONGITUDE,
                            KEY_ENTREPRENEUR_TRAINING_NAME,
                            KEY_ENTREPRENEUR_TRAINING_START_DATE,
                            KEY_ENTREPRENEUR_TRAINING_END_DATE,
                            KEY_ENTREPRENEUR_TRAINING_DESCRIPTION},
                    null,
                    null,
                    null,
                    null,
                    null);

            if (result.moveToFirst()) {
                do {

                    EnterpreneurTrainingDetailsModel.DataBean dataBean = new EnterpreneurTrainingDetailsModel.DataBean();
                    dataBean.setId(result.getLong(0));
                    dataBean.setEntrepreneurId(result.getLong(1));
                    dataBean.setCreatedDate(result.getLong(2));
                    dataBean.setCreatedBy(result.getLong(3));
                    dataBean.setLatitude(result.getDouble(4));
                    dataBean.setLongitude(result.getDouble(5));
                    dataBean.setTrainingName(result.getString(6));
                    dataBean.setTrainingStartDate(result.getLong(7));
                    dataBean.setTrainingEndDate(result.getLong(8));
                    dataBean.setTrainingDescription(result.getString(9));
                    TrainingList.add(dataBean);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        }
        return TrainingList;
    }

    // Insert new Growth Purpose List
    public long insertNewGrowthPlanPurposeList(Long KEY_KEY_NEW_GROWTH_PLAN_PURPOSE_ID,
                                               String KEY_NEW_GROWTH_PLAN_PURPOSE_VALUE) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.KEY_NEW_GROWTH_PLAN_PURPOSE_ID, KEY_KEY_NEW_GROWTH_PLAN_PURPOSE_ID);
        contentValues.put(this.KEY_NEW_GROWTH_PLAN_PURPOSE_VALUE, KEY_NEW_GROWTH_PLAN_PURPOSE_VALUE);
        return mSqLiteDatabase.insert(TABLE_NEW_GROWTH_PURPOSE_LIST, null, contentValues);
    }

    //Get New Growth Plan Purpose List
    public ArrayList<GrowthPlanGrowthPurposeListModel.DataBean.ListGPPurposeBean> getNewGrowthPlanPurposeList() {
        ArrayList<GrowthPlanGrowthPurposeListModel.DataBean.ListGPPurposeBean> getNewGrowthPlanPurposeList = new ArrayList<>();

        result = null;
        try {
            result = mSqLiteDatabase.query(TABLE_NEW_GROWTH_PURPOSE_LIST, new String[]{}, null, null,
                    null, null, null);

            if (result.moveToFirst()) {
                do {
                    GrowthPlanGrowthPurposeListModel.DataBean.ListGPPurposeBean mNewGrowthPlanGrowthPurposeListModel = new GrowthPlanGrowthPurposeListModel.DataBean.ListGPPurposeBean();
                    mNewGrowthPlanGrowthPurposeListModel.setId(result.getLong(1));
                    mNewGrowthPlanGrowthPurposeListModel.setValue(result.getString(2));
                    getNewGrowthPlanPurposeList.add(mNewGrowthPlanGrowthPurposeListModel);

                } while (result.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return getNewGrowthPlanPurposeList;
    }

    //ENTERPRENEUR EXPENDITURE DATA
    public long insertEntrepreneurExpenditureRegistration(String expanditureModelArrayList) {

        ContentValues values = new ContentValues();

        values.put(KEY_ENTREPRENEUR_EXPENDITURE, expanditureModelArrayList);

        return mSqLiteDatabase.insert(TABLE_ENTREPRENEUR_EXPENDITURE, null, values);

    }

    public ArrayList<ExpanditureModel> getEntrepreneurExpenditureRegistration() {
        ArrayList<ExpanditureModel> mEntrepreneurCreditRegistrationModelList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query(TABLE_ENTREPRENEUR_EXPENDITURE, new String[]{}, null, null,
                    null, null, null);

            if (result.moveToFirst()) {
                do {

                    String strExpenditureArrayList = result.getString(1);

                    Gson gson = new Gson();
                    TypeToken<ArrayList<ExpanditureModel>> token = new TypeToken<ArrayList<ExpanditureModel>>() {
                    };

                    mEntrepreneurCreditRegistrationModelList = gson.fromJson(strExpenditureArrayList, token.getType());

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurCreditRegistrationModelList;
    }

    //INSERT AND GET EXPENDITURE DETAILS
    public Long insertFamilyExpenditureList(Long createdBy,
                                            Long modifiedBy,
                                            long createdDate,
                                            Long id,
                                            String itemType,
                                            double monthlyExpence,
                                            Double annualExpence,
                                            Long entrepreneurId,
                                            Long itemTypeId,
                                            Double longitude,
                                            Double latitude,
                                            int deleted
    ) {

        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_CREATED_BY_GET, createdBy);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_MODIFIED_BY_GET, modifiedBy);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_CREATED_DATE_GET, createdDate);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ID_GET, id);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ITEM_TYPE_GET, itemType);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_MONTHLY_EXPENSE_GET, monthlyExpence);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ANNUAL_EXPENSE_GET, annualExpence);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ENTREPRENEUR_ID_GET, entrepreneurId);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ITEM_TYPE_ID_GET, itemTypeId);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_LONGITUDE_GET, longitude);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_LATITUDE_GET, latitude);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_DELETED_GET, deleted);

        return mSqLiteDatabase.insert(TABLE_ENTREPRENUR_EXPENDITURES_LIST, null, values);
    }

    //UPDATE ENTERPRENEUR DATA
    public int updateFamilyExpenditureList(Long createdBy,
                                           Long modifiedBy,
                                           long createdDate,
                                           Long id,
                                           String itemType,
                                           double monthlyExpence,
                                           Double annualExpence,
                                           Long entrepreneurId,
                                           Long itemTypeId,
                                           Double longitude,
                                           Double latitude,
                                           int deleted
    ) {
        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_CREATED_BY_GET, createdBy);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_MODIFIED_BY_GET, modifiedBy);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_CREATED_DATE_GET, createdDate);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ID_GET, id);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ITEM_TYPE_GET, itemType);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_MONTHLY_EXPENSE_GET, monthlyExpence);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ANNUAL_EXPENSE_GET, annualExpence);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ENTREPRENEUR_ID_GET, entrepreneurId);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ITEM_TYPE_ID_GET, itemTypeId);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_LONGITUDE_GET, longitude);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_LATITUDE_GET, latitude);
        values.put(KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_DELETED_GET, deleted);

        return mSqLiteDatabase.update(TABLE_ENTREPRENUR_EXPENDITURES_LIST, values,
                this.KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ID_GET + "=?", new String[]{String.valueOf(id)});
    }

    public ArrayList<EntrepreneurListModel.DataBean.FamilyExpendituresBean> getAllFamilyExpendituresList(Long id) {
        ArrayList<EntrepreneurListModel.DataBean.FamilyExpendituresBean> mFamilyExpenditureListBean = new ArrayList<>();

        try {

            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENUR_EXPENDITURES_LIST,
                            new String[]{
                                    KEY_ID,
                                    KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_CREATED_BY_GET,
                                    KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_MODIFIED_BY_GET,
                                    KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_CREATED_DATE_GET,
                                    KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ID_GET,
                                    KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ITEM_TYPE_GET,
                                    KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_MONTHLY_EXPENSE_GET,
                                    KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ANNUAL_EXPENSE_GET,
                                    KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ENTREPRENEUR_ID_GET,
                                    KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ITEM_TYPE_ID_GET,
                                    KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_LONGITUDE_GET,
                                    KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_LATITUDE_GET,
                                    KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_DELETED_GET},

                            KEY_ENTREPRENEUR_EXPENDITURE_DETAILS_ENTREPRENEUR_ID_GET + "=" + id,
                            null, null, null, null, null
                    );

            if (result.moveToFirst()) {
                do {
                    EntrepreneurListModel.DataBean.FamilyExpendituresBean mFamilyExpenditureListModel = new EntrepreneurListModel.DataBean.FamilyExpendituresBean();
                    mFamilyExpenditureListModel.setCreatedBy(result.getLong(1));
                    mFamilyExpenditureListModel.setModifiedBy(result.getLong(2));
                    mFamilyExpenditureListModel.setCreatedDate(result.getLong(3));
                    mFamilyExpenditureListModel.setId(result.getLong(4));
                    mFamilyExpenditureListModel.setItemType(result.getString(5));
                    mFamilyExpenditureListModel.setMonthlyExpence(result.getDouble(6));
                    mFamilyExpenditureListModel.setAnnualExpence(result.getDouble(7));
                    mFamilyExpenditureListModel.setEntrepreneurId(result.getLong(8));
                    mFamilyExpenditureListModel.setItemTypeId(result.getLong(9));
                    mFamilyExpenditureListModel.setLongitude(result.getDouble(10));
                    mFamilyExpenditureListModel.setLatitude(result.getDouble(11));

                    if (result.getInt(12) == 1) {
                        mFamilyExpenditureListModel.setDeleted(true);
                    } else {
                        mFamilyExpenditureListModel.setDeleted(false);
                    }
                    mFamilyExpenditureListBean.add(mFamilyExpenditureListModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }
        return mFamilyExpenditureListBean;
    }


    //INSERT, UPDATE GET ENTERPRENEUR INCOME PROIFILE DETAILS
    public Long insertIncomeProfleDetail(Long KEY_ENTERPRENEUR_ID,
                                         Double KEY_LATITUDE,
                                         Double KEY_LONGITUDE,
                                         String KEY_ENTREPRENEUR_INCOME_ANNUAL_INCOME,
                                         Long KEY_ENTREPRENEUR_INCOME_ANNUAL_INCOME_ID,
                                         String KEY_ENTREPRENEUR_INCOME_SELF_INCOME,
                                         Long KEY_ENTREPRENEUR_INCOME_SELF_INCOME_ID,
                                         Long KEY_CREATED_BY,
                                         Long KEY_CREATED_DATE) {

        ContentValues values = new ContentValues();
        values.put(this.KEY_ENTERPRENEUR_ID, KEY_ENTERPRENEUR_ID);
        values.put(this.KEY_LATITUDE, KEY_LATITUDE);
        values.put(this.KEY_LONGITUDE, KEY_LONGITUDE);
        values.put(this.KEY_ENTREPRENEUR_INCOME_ANNUAL_INCOME, KEY_ENTREPRENEUR_INCOME_ANNUAL_INCOME);
        values.put(this.KEY_ENTREPRENEUR_INCOME_ANNUAL_INCOME_ID, KEY_ENTREPRENEUR_INCOME_ANNUAL_INCOME_ID);
        values.put(this.KEY_ENTREPRENEUR_INCOME_SELF_INCOME, KEY_ENTREPRENEUR_INCOME_SELF_INCOME);
        values.put(this.KEY_ENTREPRENEUR_INCOME_SELF_INCOME_ID, KEY_ENTREPRENEUR_INCOME_SELF_INCOME_ID);
        values.put(this.KEY_CREATED_BY, KEY_CREATED_BY);
        values.put(this.KEY_CREATED_DATE, KEY_CREATED_DATE);

        return mSqLiteDatabase.insert(TABLE_ENTREPRENUR_INCOME_PROFILE, null, values);
    }

    //UPDATE ENTERPRENEUR DATA
    public int updateIncomeProfleDetail(Long KEY_ENTERPRENEUR_ID,
                                        Double KEY_LATITUDE,
                                        Double KEY_LONGITUDE,
                                        String KEY_ENTREPRENEUR_INCOME_ANNUAL_INCOME,
                                        Long KEY_ENTREPRENEUR_INCOME_ANNUAL_INCOME_ID,
                                        String KEY_ENTREPRENEUR_INCOME_SELF_INCOME,
                                        Long KEY_ENTREPRENEUR_INCOME_SELF_INCOME_ID,
                                        Long KEY_CREATED_BY,
                                        Long KEY_CREATED_DATE) {

        ContentValues values = new ContentValues();
        values.put(this.KEY_ENTERPRENEUR_ID, KEY_ENTERPRENEUR_ID);
        values.put(this.KEY_LATITUDE, KEY_LATITUDE);
        values.put(this.KEY_LONGITUDE, KEY_LONGITUDE);
        values.put(this.KEY_ENTREPRENEUR_INCOME_ANNUAL_INCOME, KEY_ENTREPRENEUR_INCOME_ANNUAL_INCOME);
        values.put(this.KEY_ENTREPRENEUR_INCOME_ANNUAL_INCOME_ID, KEY_ENTREPRENEUR_INCOME_ANNUAL_INCOME_ID);
        values.put(this.KEY_ENTREPRENEUR_INCOME_SELF_INCOME, KEY_ENTREPRENEUR_INCOME_SELF_INCOME);
        values.put(this.KEY_ENTREPRENEUR_INCOME_SELF_INCOME_ID, KEY_ENTREPRENEUR_INCOME_SELF_INCOME_ID);
        values.put(this.KEY_CREATED_BY, KEY_CREATED_BY);
        values.put(this.KEY_CREATED_DATE, KEY_CREATED_DATE);

        return mSqLiteDatabase.update(TABLE_ENTREPRENUR_INCOME_PROFILE, values,
                this.KEY_ENTERPRENEUR_ID + "=?", new String[]{String.valueOf(KEY_ENTERPRENEUR_ID)});
    }

    public ArrayList<EnterpreneurIncomeProfileModel> getAllEnterpreneurIncomeProfile(Long id) {
        ArrayList<EnterpreneurIncomeProfileModel> mEnterpreneurIncomeProfileList = new ArrayList<>();

        try {

            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENUR_INCOME_PROFILE,
                            new String[]{
                                    KEY_ID,
                                    KEY_ENTERPRENEUR_ID,
                                    KEY_LATITUDE,
                                    KEY_LONGITUDE,
                                    KEY_ENTREPRENEUR_INCOME_ANNUAL_INCOME,
                                    KEY_ENTREPRENEUR_INCOME_ANNUAL_INCOME_ID,
                                    KEY_ENTREPRENEUR_INCOME_SELF_INCOME,
                                    KEY_ENTREPRENEUR_INCOME_SELF_INCOME_ID,
                                    KEY_CREATED_BY,
                                    KEY_CREATED_DATE},
                            KEY_ENTERPRENEUR_ID + "=" + id,
                            null, null, null, null, null
                    );

            if (result.moveToFirst()) {
                do {
                    EnterpreneurIncomeProfileModel mEnterpreneurIncomeProfileModel = new EnterpreneurIncomeProfileModel();
                    mEnterpreneurIncomeProfileModel.setEnterpreneurID(result.getLong(1));
                    mEnterpreneurIncomeProfileModel.setLatitude(result.getDouble(2));
                    mEnterpreneurIncomeProfileModel.setLongitude(result.getDouble(3));
                    mEnterpreneurIncomeProfileModel.setAnnualIncome(result.getString(4));
                    mEnterpreneurIncomeProfileModel.setAnnualIncomeID(result.getLong(5));
                    mEnterpreneurIncomeProfileModel.setSelfIncome(result.getString(6));
                    mEnterpreneurIncomeProfileModel.setSelfIncomeID(result.getLong(7));
                    mEnterpreneurIncomeProfileModel.setCreatedBy(result.getLong(8));
                    mEnterpreneurIncomeProfileModel.setCreatedDate(result.getLong(9));
                    mEnterpreneurIncomeProfileList.add(mEnterpreneurIncomeProfileModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }
        return mEnterpreneurIncomeProfileList;
    }

    //INSERT AND GET ALL DATA FOR BUSINESS PLAN STEP-1
    //----------(Insert and get Entrepreneur Businessplan step -1.0 )------------//
    public long insertEntrepreneurBP_1_0_step(String strNameOfUnit,
                                              String strAddressOfUnit,
                                              Long entrepreneurId,
                                              Long businessplanId,
                                              Long natureOfUnitId,
                                              String strIsGovtLicence,
                                              String strPincode,
                                              Long stateId,
                                              Long DistrictId,
                                              Long BlockId,
                                              Long VillageId,
                                              Long LicenseDate,
                                              String strGovtLicenseRegNo,
                                              String type,
                                              String sector,
                                              Long createdDate,
                                              int isBusinessPlanPendingOrSubmitted,
                                              int syncStatus,
                                              int isModelBusinessPlan,
                                              int isBusinessPlanSubmite) {

        ContentValues values = new ContentValues();

        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_NAME_OF_UNIT, strNameOfUnit);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_ADDRESS_OF_UNIT, strAddressOfUnit);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_ENTREPRENEUR_ID, entrepreneurId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_BP_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_NATURE_OF_ID, natureOfUnitId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_IS_GOVT_LICENCE, strIsGovtLicence);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_PINCODE, strPincode);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_STATE_ID, stateId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_DISTRICT_ID, DistrictId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_BLOCK_ID, BlockId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_VILLAGE_ID, VillageId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_LICENCE_DATE, LicenseDate);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_LICENCE_REG_NO, strGovtLicenseRegNo);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_TYPE_NO, type);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_SECTOR_NO, sector);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_CREATED_DATE, createdDate);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_BP_FLAG, isBusinessPlanPendingOrSubmitted);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_BP_SYNC_STATUS, syncStatus);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_IS_MODEL_BUSINESS_PLAN, isModelBusinessPlan);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_IS_BUSINESS_PLAN_SUBMITE, isBusinessPlanSubmite);
        return mSqLiteDatabase.insert(TABLE_ENTREPRENEUR_BUSINESSPLAN_1_0_CREATE, null, values);

    }


    /*public int updateEntrepreneurBP_1_0_step(Long entrepreneurId, Long businessplanId, int isBusinessPlanPendingOrSubmitted) {
        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_ENTREPRENEUR_ID, entrepreneurId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_BP_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_BP_FLAG, isBusinessPlanPendingOrSubmitted);

        String whereArgs[] = new String[1];
        whereArgs[0] = "" + entrepreneurId;
        //whereArgs[1] = "" + productType ;
        return mSqLiteDatabase.update(TABLE_ENTREPRENEUR_BUSINESSPLAN_1_0_CREATE, values, KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_ENTREPRENEUR_ID + "= ?", whereArgs);
    }*/

    //UPDATE ENTERPRENEUR BUSINESS PLAN CREATE STATUS
    public int updateEntrepreneurBP_1_0_step(Long enterpreneuerID, int intStatus) {
        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_BP_FLAG, intStatus);
        return mSqLiteDatabase.update(TABLE_ENTREPRENEUR_BUSINESSPLAN_1_0_CREATE, values, this.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_ENTREPRENEUR_ID + "=" + enterpreneuerID, null);

    }

 /*   public int updateEntrepreneurBP_1_0_step_for_model_plan(Long entrepreneurId, Long businessplanId, int isBusinessPlanIsModel) {
        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_ENTREPRENEUR_ID, entrepreneurId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_BP_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_IS_MODEL_BUSINESS_PLAN, isBusinessPlanIsModel);

        String whereArgs[] = new String[1];
        whereArgs[0] = "" + entrepreneurId;
        //whereArgs[1] = "" + productType ;
        return mSqLiteDatabase.update(TABLE_ENTREPRENEUR_BUSINESSPLAN_1_0_CREATE, values, KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_ENTREPRENEUR_ID + "= ?", whereArgs);
    }*/

    //UPDATE ENTERPRENEUR BUSINESS PLAN CREATE STATUS
    public int updateEntrepreneurBP_1_0_step_for_model_plan(Long enterpreneuerID, int intStatus) {
        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_IS_MODEL_BUSINESS_PLAN, intStatus);
        return mSqLiteDatabase.update(TABLE_ENTREPRENEUR_BUSINESSPLAN_1_0_CREATE, values, this.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_ENTREPRENEUR_ID + "=" + enterpreneuerID, null);

    }

    //UPDATE ENTERPRENEUR BUSINESS PLAN CREATE STATUS
    public int updateEntrepreneurBP_1_0_step_is_business_plan_submitted(Long enterpreneuerID, int intStatus) {
        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_IS_BUSINESS_PLAN_SUBMITE, intStatus);
        return mSqLiteDatabase.update(TABLE_ENTREPRENEUR_BUSINESSPLAN_1_0_CREATE, values, this.KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_ENTREPRENEUR_ID + "=" + enterpreneuerID, null);

    }


    public ArrayList<SaveEnterpriseModel> getEntrepreneurBusinessplan_step_1_0_lList(Long entrepreneurId) {
        ArrayList<SaveEnterpriseModel> mEntrepreneurBusinessplan_step_1_0_lList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENEUR_BUSINESSPLAN_1_0_CREATE,
                            new String[]{
                                    KEY_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_NAME_OF_UNIT,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_ADDRESS_OF_UNIT,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_ENTREPRENEUR_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_BP_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_NATURE_OF_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_IS_GOVT_LICENCE,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_PINCODE,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_STATE_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_DISTRICT_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_BLOCK_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_VILLAGE_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_LICENCE_DATE,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_LICENCE_REG_NO,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_TYPE_NO,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_SECTOR_NO,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_CREATED_DATE,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_BP_FLAG,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_BP_SYNC_STATUS,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_IS_MODEL_BUSINESS_PLAN,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_IS_BUSINESS_PLAN_SUBMITE},

                            KEY_ENTREPRENEUR_BUSINESSPLAN_1_0_ENTREPRENEUR_ID + "=" + entrepreneurId,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {
                do {

                    SaveEnterpriseModel mSaveEnterpriseModel = new SaveEnterpriseModel();
                    mSaveEnterpriseModel.setNameOfUnit(result.getString(1));
                    mSaveEnterpriseModel.setAddressOfUnit(result.getString(2));
                    mSaveEnterpriseModel.setEntrepreneurId(result.getLong(3));
                    mSaveEnterpriseModel.setBusinessPlanId(result.getLong(4));
                    mSaveEnterpriseModel.setNatureOfUnitId(result.getLong(5));
                    mSaveEnterpriseModel.setGovtLicense(result.getString(6));
                    mSaveEnterpriseModel.setPincode(result.getString(7));
                    mSaveEnterpriseModel.setStateId(result.getLong(8));
                    mSaveEnterpriseModel.setDistrictId(result.getLong(9));
                    mSaveEnterpriseModel.setBlockId(result.getLong(10));
                    mSaveEnterpriseModel.setVillageId(result.getLong(11));
                    mSaveEnterpriseModel.setLicenseDate(result.getLong(12));
                    mSaveEnterpriseModel.setRegisterNo(result.getString(13));
                    mSaveEnterpriseModel.setType(result.getString(14));
                    mSaveEnterpriseModel.setSector(result.getString(15));
                    mSaveEnterpriseModel.setCreatedDate(Long.valueOf(result.getString(16)));
                    mSaveEnterpriseModel.setFlag(result.getInt(17));
                    mSaveEnterpriseModel.setSyncStatus(result.getInt(18));
                    mSaveEnterpriseModel.setIsModelBusinessPlan(result.getInt(19));
                    mSaveEnterpriseModel.setIsBusinessPlanSubmited(result.getInt(20));
                    mEntrepreneurBusinessplan_step_1_0_lList.add(mSaveEnterpriseModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {

            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_1_0_lList;
    }

    //KETAN GET ALL LIST OF BUSINESS PLAN STEP ONE
    public ArrayList<SaveEnterpriseModel> getEntrepreneurBusinessplan_step_1_0_lListALL() {
        ArrayList<SaveEnterpriseModel> mEntrepreneurBusinessplan_step_1_0_lList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query(TABLE_ENTREPRENEUR_BUSINESSPLAN_1_0_CREATE, new String[]{}, null, null,
                    null, null, null);

            if (result.moveToFirst()) {
                do {

                    SaveEnterpriseModel mSaveEnterpriseModel = new SaveEnterpriseModel();
                    mSaveEnterpriseModel.setNameOfUnit(result.getString(1));
                    mSaveEnterpriseModel.setAddressOfUnit(result.getString(2));
                    mSaveEnterpriseModel.setEntrepreneurId(result.getLong(3));
                    mSaveEnterpriseModel.setBusinessPlanId(result.getLong(4));
                    mSaveEnterpriseModel.setNatureOfUnitId(result.getLong(5));
                    mSaveEnterpriseModel.setGovtLicense(result.getString(6));
                    mSaveEnterpriseModel.setPincode(result.getString(7));
                    mSaveEnterpriseModel.setStateId(result.getLong(8));
                    mSaveEnterpriseModel.setDistrictId(result.getLong(9));
                    mSaveEnterpriseModel.setBlockId(result.getLong(10));
                    mSaveEnterpriseModel.setVillageId(result.getLong(11));
                    mSaveEnterpriseModel.setLicenseDate(result.getLong(12));
                    mSaveEnterpriseModel.setRegisterNo(result.getString(13));
                    mSaveEnterpriseModel.setType(result.getString(14));
                    mSaveEnterpriseModel.setSector(result.getString(15));
                    mSaveEnterpriseModel.setCreatedDate(Long.valueOf(result.getString(16)));
                    mSaveEnterpriseModel.setFlag(result.getInt(17));
                    mSaveEnterpriseModel.setSyncStatus(result.getInt(18));
                    mSaveEnterpriseModel.setIsModelBusinessPlan(result.getInt(19));
                    mSaveEnterpriseModel.setIsBusinessPlanSubmited(result.getInt(20));
                    mEntrepreneurBusinessplan_step_1_0_lList.add(mSaveEnterpriseModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {

            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_1_0_lList;
    }

    //INSERT, GET AND UPDATE BUSINESS PLAN STEP-2 DATA
    public Long insertNewbusinessPlanStep2ProductionAndRevenueData(Long KEY_NEW_BUSINESS_PLAN_ITEM_ID,
                                                                   Long KEY_NEW_BUSINESS_PLAN_ID,
                                                                   String KEY_NEW_BUSINESS_PLAN_STEP_20_PRODUCT_NAME,
                                                                   String KEY_NEW_BUSINESS_PLAN_STEP_20_WORKING_UNITES,
                                                                   String KEY_NEW_BUSINESS_PLAN_STEP_20_ENTER_WORKING_UNITES,
                                                                   double KEY_NEW_BUSINESS_PLAN_STEP_20_PER_DAY_EIGHT_HOURS,
                                                                   double KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_PRODUCTION,
                                                                   double KEY_NEW_BUSINESS_PLAN_STEP_20_PER_DAY_SIXTY_PERCENT,
                                                                   double KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_UTILIZATION,
                                                                   double KEY_NEW_BUSINESS_PLAN_STEP_20_SALE_PRICE_PER_UNIT,
                                                                   double KEY_NEW_BUSINESS_PLAN_STEP_20_AMOUNT,
                                                                   int KEY_NEW_BUSINESS_PLAN_STEP_20_SALE_IN_PERCENTAGE,
                                                                   int KEY_NEW_BUSINESS_PLAN_STEP_20_IS_FIELD_EDITBLE,
                                                                   double KEY_NEW_BUSINESS_PLAN_STEP_20_COST_PRICE,
                                                                   double KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_COST_PRICE
    ) {

        ContentValues values = new ContentValues();
        values.put(this.KEY_NEW_BUSINESS_PLAN_ITEM_ID, KEY_NEW_BUSINESS_PLAN_ITEM_ID);
        values.put(this.KEY_NEW_BUSINESS_PLAN_ID, KEY_NEW_BUSINESS_PLAN_ID);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_PRODUCT_NAME, KEY_NEW_BUSINESS_PLAN_STEP_20_PRODUCT_NAME);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_WORKING_UNITES, KEY_NEW_BUSINESS_PLAN_STEP_20_WORKING_UNITES);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_ENTER_WORKING_UNITES, KEY_NEW_BUSINESS_PLAN_STEP_20_ENTER_WORKING_UNITES);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_PER_DAY_EIGHT_HOURS, KEY_NEW_BUSINESS_PLAN_STEP_20_PER_DAY_EIGHT_HOURS);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_PRODUCTION, KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_PRODUCTION);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_PER_DAY_SIXTY_PERCENT, KEY_NEW_BUSINESS_PLAN_STEP_20_PER_DAY_SIXTY_PERCENT);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_UTILIZATION, KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_UTILIZATION);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_SALE_PRICE_PER_UNIT, KEY_NEW_BUSINESS_PLAN_STEP_20_SALE_PRICE_PER_UNIT);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_AMOUNT, KEY_NEW_BUSINESS_PLAN_STEP_20_AMOUNT);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_SALE_IN_PERCENTAGE ,KEY_NEW_BUSINESS_PLAN_STEP_20_SALE_IN_PERCENTAGE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_IS_FIELD_EDITBLE, KEY_NEW_BUSINESS_PLAN_STEP_20_IS_FIELD_EDITBLE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_COST_PRICE, KEY_NEW_BUSINESS_PLAN_STEP_20_COST_PRICE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_COST_PRICE, KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_COST_PRICE);
        return mSqLiteDatabase.insert(TABLE_NEW_BUSINESS_PLAN_DATA, null, values);
    }

    public ArrayList<GetNewBusinessPlanDataModel.DataBean.ProductionAndRevenuesBean> getNewbusinessPlanStep2ProductionAndRevenueData(Long BusinessPlanID) {
        ArrayList<GetNewBusinessPlanDataModel.DataBean.ProductionAndRevenuesBean> productionAndRevenueDetailModelBeenList = new ArrayList<>();

        try {

            result = mSqLiteDatabase.query
                    (TABLE_NEW_BUSINESS_PLAN_DATA,
                            new String[]{
                                    KEY_ID,
                                    KEY_NEW_BUSINESS_PLAN_ITEM_ID,
                                    KEY_NEW_BUSINESS_PLAN_ID,
                                    KEY_NEW_BUSINESS_PLAN_STEP_20_PRODUCT_NAME,
                                    KEY_NEW_BUSINESS_PLAN_STEP_20_WORKING_UNITES,
                                    KEY_NEW_BUSINESS_PLAN_STEP_20_ENTER_WORKING_UNITES,
                                    KEY_NEW_BUSINESS_PLAN_STEP_20_PER_DAY_EIGHT_HOURS,
                                    KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_PRODUCTION,
                                    KEY_NEW_BUSINESS_PLAN_STEP_20_PER_DAY_SIXTY_PERCENT,
                                    KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_UTILIZATION,
                                    KEY_NEW_BUSINESS_PLAN_STEP_20_SALE_PRICE_PER_UNIT,
                                    KEY_NEW_BUSINESS_PLAN_STEP_20_AMOUNT,
                                    KEY_NEW_BUSINESS_PLAN_STEP_20_SALE_IN_PERCENTAGE,
                                    KEY_NEW_BUSINESS_PLAN_STEP_20_IS_FIELD_EDITBLE,
                                    KEY_NEW_BUSINESS_PLAN_STEP_20_COST_PRICE,
                                    KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_COST_PRICE},
                            KEY_NEW_BUSINESS_PLAN_ID + "=" + BusinessPlanID,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {
                do {
                    GetNewBusinessPlanDataModel.DataBean.ProductionAndRevenuesBean productionAndRevenueDetailModelBean = new GetNewBusinessPlanDataModel.DataBean.ProductionAndRevenuesBean();
                    productionAndRevenueDetailModelBean.setId(result.getLong(1));
                    productionAndRevenueDetailModelBean.setBusinessPlanId(result.getLong(2));
                    productionAndRevenueDetailModelBean.setProductName(result.getString(3));
                    productionAndRevenueDetailModelBean.setWorkingUnites(result.getString(4));
                    productionAndRevenueDetailModelBean.setWorkingUnitsType(result.getString(5));
                    productionAndRevenueDetailModelBean.setPerDayEightHours(result.getDouble(6));
                    productionAndRevenueDetailModelBean.setTotalProduction(result.getDouble(7));
                    productionAndRevenueDetailModelBean.setPerDaySixtyPercent(result.getDouble(8));
                    productionAndRevenueDetailModelBean.setTotalUtilization(result.getDouble(9));
                    productionAndRevenueDetailModelBean.setSalePricePerUnit(result.getDouble(10));
                    productionAndRevenueDetailModelBean.setAmount(result.getDouble(11));
                    productionAndRevenueDetailModelBean.setSalePercentage(result.getInt(12));
                    productionAndRevenueDetailModelBean.setEditble(result.getInt(13));
                    productionAndRevenueDetailModelBean.setCostPrice(result.getInt(14));
                    productionAndRevenueDetailModelBean.setTotalCostOfGoods(result.getInt(15));
                    productionAndRevenueDetailModelBeenList.add(productionAndRevenueDetailModelBean);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }
        return productionAndRevenueDetailModelBeenList;
    }


    //KETAN GET ALL LIST OF STEP 2.0 OF BUSINESS PLAN

    public ArrayList<ProductionAndRevenueDetailModel.ProductionAndRevenueDetailModelBean> getNewbusinessPlanStep2ProductionAndRevenueDataALL() {
        ArrayList<ProductionAndRevenueDetailModel.ProductionAndRevenueDetailModelBean> productionAndRevenueDetailModelBeenList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query(TABLE_NEW_BUSINESS_PLAN_DATA, new String[]{}, null, null,
                    null, null, null);


            if (result.moveToFirst()) {
                do {
                    ProductionAndRevenueDetailModel.ProductionAndRevenueDetailModelBean productionAndRevenueDetailModelBean = new ProductionAndRevenueDetailModel.ProductionAndRevenueDetailModelBean();
                    productionAndRevenueDetailModelBean.setId(result.getLong(1));
                    productionAndRevenueDetailModelBean.setBusinessPlanId(result.getLong(2));
                    productionAndRevenueDetailModelBean.setProductName(result.getString(3));
                    productionAndRevenueDetailModelBean.setWorkingUnites(result.getString(4));
                    productionAndRevenueDetailModelBean.setEnterdWorkingUnits(result.getString(5));
                    productionAndRevenueDetailModelBean.setPerDayEightHours(result.getDouble(6));
                    productionAndRevenueDetailModelBean.setTotalProduction(result.getDouble(7));
                    productionAndRevenueDetailModelBean.setPerDaySixtyPercent(result.getDouble(8));
                    productionAndRevenueDetailModelBean.setTotalUtilization(result.getDouble(9));
                    productionAndRevenueDetailModelBean.setSalePricePerUnit(result.getDouble(10));
                    productionAndRevenueDetailModelBean.setAmount(result.getDouble(11));
                    productionAndRevenueDetailModelBean.setSalePercentage(result.getInt(12));
                    productionAndRevenueDetailModelBean.setEditble(result.getInt(13));
                    productionAndRevenueDetailModelBean.setCostPrice(result.getInt(14));
                    productionAndRevenueDetailModelBean.setTotalCostOfGoods(result.getInt(15));
                    productionAndRevenueDetailModelBeenList.add(productionAndRevenueDetailModelBean);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }
        return productionAndRevenueDetailModelBeenList;
    }


    //update Business Plan producation and revenue list item.
    public int updateNewBusinessPlan20ProductionAndRevenueData(Long KEY_NEW_BUSINESS_PLAN_ITEM_ID,
                                                               Long KEY_NEW_BUSINESS_PLAN_ID,
                                                               String KEY_NEW_BUSINESS_PLAN_STEP_20_PRODUCT_NAME,
                                                               String KEY_NEW_BUSINESS_PLAN_STEP_20_WORKING_UNITES,
                                                               String KEY_NEW_BUSINESS_PLAN_STEP_20_ENTER_WORKING_UNITES,
                                                               double KEY_NEW_BUSINESS_PLAN_STEP_20_PER_DAY_EIGHT_HOURS,
                                                               double KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_PRODUCTION,
                                                               double KEY_NEW_BUSINESS_PLAN_STEP_20_PER_DAY_SIXTY_PERCENT,
                                                               double KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_UTILIZATION,
                                                               double KEY_NEW_BUSINESS_PLAN_STEP_20_SALE_PRICE_PER_UNIT,
                                                               double KEY_NEW_BUSINESS_PLAN_STEP_20_AMOUNT,
                                                               int KEY_NEW_BUSINESS_PLAN_STEP_20_SALE_IN_PERCENTAGE,
                                                               int KEY_NEW_BUSINESS_PLAN_STEP_20_IS_FIELD_EDITBLE,
                                                               double KEY_NEW_BUSINESS_PLAN_STEP_20_COST_PRICE,
                                                               double KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_COST_PRICE


    ) {
        ContentValues values = new ContentValues();
        values.put(this.KEY_NEW_BUSINESS_PLAN_ITEM_ID, KEY_NEW_BUSINESS_PLAN_ITEM_ID);
        values.put(this.KEY_NEW_BUSINESS_PLAN_ID, KEY_NEW_BUSINESS_PLAN_ID);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_PRODUCT_NAME, KEY_NEW_BUSINESS_PLAN_STEP_20_PRODUCT_NAME);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_WORKING_UNITES, KEY_NEW_BUSINESS_PLAN_STEP_20_WORKING_UNITES);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_ENTER_WORKING_UNITES, KEY_NEW_BUSINESS_PLAN_STEP_20_ENTER_WORKING_UNITES);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_PER_DAY_EIGHT_HOURS, KEY_NEW_BUSINESS_PLAN_STEP_20_PER_DAY_EIGHT_HOURS);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_PRODUCTION, KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_PRODUCTION);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_PER_DAY_SIXTY_PERCENT, KEY_NEW_BUSINESS_PLAN_STEP_20_PER_DAY_SIXTY_PERCENT);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_UTILIZATION, KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_UTILIZATION);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_SALE_PRICE_PER_UNIT, KEY_NEW_BUSINESS_PLAN_STEP_20_SALE_PRICE_PER_UNIT);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_AMOUNT, KEY_NEW_BUSINESS_PLAN_STEP_20_AMOUNT);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_SALE_IN_PERCENTAGE, KEY_NEW_BUSINESS_PLAN_STEP_20_SALE_IN_PERCENTAGE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_IS_FIELD_EDITBLE, KEY_NEW_BUSINESS_PLAN_STEP_20_IS_FIELD_EDITBLE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_COST_PRICE, KEY_NEW_BUSINESS_PLAN_STEP_20_COST_PRICE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_COST_PRICE, KEY_NEW_BUSINESS_PLAN_STEP_20_TOTAL_COST_PRICE);
        return mSqLiteDatabase.update(TABLE_NEW_BUSINESS_PLAN_DATA, values, this.KEY_NEW_BUSINESS_PLAN_ITEM_ID + "=" + KEY_NEW_BUSINESS_PLAN_ITEM_ID, null);

    }

    //INSERT, UPDATE AND GET BUSINESS PLAN STEP 2.1 DATA
    //INSERT STEP 2.1 DATA
    public long insertBusinessPlanStep2_1(String strParticular, Double amount, Long businessplanId, Long entrepreneurId) {


        ContentValues values = new ContentValues();

        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_PRODUCT, strParticular);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_AMOUNT, amount);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_BUSINESSPLAN_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_ENTREPRENEUR_ID, entrepreneurId);

        return mSqLiteDatabase.insert(TABLE_ENTREPRENEUR_BUSINESSPLAN_2_1_CREATE, null, values);
    }

    //UPDATE STEP 2.1 DATA
    public long updateBusinessPlanStep2_1(String strParticular, Double amount, Long businessplanId, Long entrepreneurId) {
        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_PRODUCT, strParticular);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_AMOUNT, amount);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_BUSINESSPLAN_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_ENTREPRENEUR_ID, entrepreneurId);
        String whereArgs[] = new String[1];
        whereArgs[0] = "" + entrepreneurId;
        return mSqLiteDatabase.update(TABLE_ENTREPRENEUR_BUSINESSPLAN_2_1_CREATE, values, KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_ENTREPRENEUR_ID + "= ?", whereArgs);
    }

    //DELETE 2.1 DATA
    public long deleteBusinessPlanStep2_1(Long entrepreneurId) {
        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_ENTREPRENEUR_ID, entrepreneurId);
        String whereArgs[] = new String[1];
        whereArgs[0] = "" + entrepreneurId;
        return mSqLiteDatabase.delete(TABLE_ENTREPRENEUR_BUSINESSPLAN_2_1_CREATE, KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_ENTREPRENEUR_ID + "= ?", whereArgs);
    }


    //GET STEP 2.1 DATA ALL
    public ArrayList<SalesRealisationModel> getBusinessPlanStep2_1_all() {
        ArrayList<SalesRealisationModel> mEntrepreneurBusinessplan_step_2_3_lList = new ArrayList<>();

        try {

            result = mSqLiteDatabase.query(TABLE_ENTREPRENEUR_BUSINESSPLAN_2_1_CREATE, new String[]{}, null, null,
                    null, null, null);

            if (result.moveToFirst()) {
                do {
                    SalesRealisationModel mSalesRealisationModel = new SalesRealisationModel();
                    mSalesRealisationModel.setParticulars(result.getString(1));
                    mSalesRealisationModel.setAmount(result.getDouble(2));
                    mSalesRealisationModel.setBusinessPlanId(result.getLong(3));
                    mSalesRealisationModel.setEntrepreneurId(result.getLong(4));

                    mEntrepreneurBusinessplan_step_2_3_lList.add(mSalesRealisationModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_2_3_lList;
    }


    //GET STEP 2.1 DATA
    public ArrayList<SalesRealisationModel> getBusinessPlanStep2_1_by_id(Long entrepreneurId) {
        ArrayList<SalesRealisationModel> mEntrepreneurBusinessplan_step_2_3_lList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENEUR_BUSINESSPLAN_2_1_CREATE,
                            new String[]{
                                    KEY_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_PRODUCT,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_AMOUNT,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_BUSINESSPLAN_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_ENTREPRENEUR_ID},

                            KEY_ENTREPRENEUR_BUSINESSPLAN_2_1_ENTREPRENEUR_ID + "=" + entrepreneurId,
                            null, null, null, null, null
                    );

            if (result.moveToFirst()) {
                do {
                    SalesRealisationModel mSalesRealisationModel = new SalesRealisationModel();
                    mSalesRealisationModel.setParticulars(result.getString(1));
                    mSalesRealisationModel.setAmount(result.getDouble(2));
                    mSalesRealisationModel.setBusinessPlanId(result.getLong(3));
                    mSalesRealisationModel.setEntrepreneurId(result.getLong(4));

                    mEntrepreneurBusinessplan_step_2_3_lList.add(mSalesRealisationModel);


                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_2_3_lList;
    }

    //STEP 3.0 INSERT,UPDATE AND GET DATA
    public long insertEntrepreneurBP_3_0_step(String particularsEditedAnswerModelArrayList, Long businessplanId, Long entrepreneurId) {

        ContentValues values = new ContentValues();

        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_0_LIST_OF_PREOPERATIVES, particularsEditedAnswerModelArrayList);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_0_BUSINESSPLAN_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_0_ENTREPRENEUR_ID, entrepreneurId);

        return mSqLiteDatabase.insert(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_0_CREATE, null, values);
    }

    //----------(Update and get Entrepreneur Businessplan step - 3.0 )------------//
    public long updateEntrepreneurBP_3_0_step(String particularsEditedAnswerModelArrayList, Long businessplanId, Long entrepreneurId) {

        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_0_LIST_OF_PREOPERATIVES, particularsEditedAnswerModelArrayList);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_0_BUSINESSPLAN_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_0_ENTREPRENEUR_ID, entrepreneurId);
        String whereArgs[] = new String[1];
        whereArgs[0] = "" + entrepreneurId;

        return mSqLiteDatabase.update(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_0_CREATE, values, KEY_ENTREPRENEUR_BUSINESSPLAN_3_0_ENTREPRENEUR_ID + "= ?", whereArgs);
    }


    //GET STEP 3.0  DATA ALL
    public ArrayList<SelectedParticularsModel> getEntrepreneurBusinessplan_step_3_0_lListALL() {
        ArrayList<SelectedParticularsModel> mEntrepreneurBusinessplan_step_3_0_lList = new ArrayList<>();

        try {

            result = mSqLiteDatabase.query(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_0_CREATE, new String[]{}, null, null,
                    null, null, null);

            if (result.moveToFirst()) {
                do {
                    ParticularsEditedAnswerModel mParticularsEditedAnswerModel = new ParticularsEditedAnswerModel();
                    String strpreOperativesArrayList = result.getString(1);
                    Gson gson = new Gson();
                    TypeToken<ArrayList<SelectedParticularsModel>> token = new TypeToken<ArrayList<SelectedParticularsModel>>() {
                    };
                    ArrayList<SelectedParticularsModel> selectedParticularsModelArrayList = gson.fromJson(strpreOperativesArrayList, token.getType());
                    mEntrepreneurBusinessplan_step_3_0_lList = gson.fromJson(strpreOperativesArrayList, token.getType());
                   /* mParticularsEditedAnswerModel.setListOfPreoperativeExpenditureParticular(selectedParticularsModelArrayList);
                    mParticularsEditedAnswerModel.setBusinessPlanId(result.getLong(2));
                    mParticularsEditedAnswerModel.setEntrepreneurId(result.getLong(3));

                    mEntrepreneurBusinessplan_step_3_0_lList.add(mParticularsEditedAnswerModel);*/

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_3_0_lList;
    }

    //GET STEP 3.0 DATA BY ENTERPRENEUR ID
    public ArrayList<SelectedParticularsModel> getEntrepreneurBusinessplan_step_3_0_lList(Long entrepreneurId) {
        ArrayList<SelectedParticularsModel> mEntrepreneurBusinessplan_step_3_0_lList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENEUR_BUSINESSPLAN_3_0_CREATE,
                            new String[]{
                                    KEY_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_0_LIST_OF_PREOPERATIVES,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_0_BUSINESSPLAN_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_0_ENTREPRENEUR_ID},

                            KEY_ENTREPRENEUR_BUSINESSPLAN_3_0_ENTREPRENEUR_ID + "=" + entrepreneurId,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {
                do {
                    ParticularsEditedAnswerModel mParticularsEditedAnswerModel = new ParticularsEditedAnswerModel();
                    String strpreOperativesArrayList = result.getString(1);
                    Gson gson = new Gson();
                    TypeToken<ArrayList<SelectedParticularsModel>> token = new TypeToken<ArrayList<SelectedParticularsModel>>() {
                    };
                    ArrayList<SelectedParticularsModel> selectedParticularsModelArrayList = gson.fromJson(strpreOperativesArrayList, token.getType());
                    mEntrepreneurBusinessplan_step_3_0_lList = gson.fromJson(strpreOperativesArrayList, token.getType());
                  /*  mParticularsEditedAnswerModel.setListOfPreoperativeExpenditureParticular(selectedParticularsModelArrayList);
                    mParticularsEditedAnswerModel.setBusinessPlanId(result.getLong(2));
                    mParticularsEditedAnswerModel.setEntrepreneurId(result.getLong(3));

                    mEntrepreneurBusinessplan_step_3_0_lList.add(mParticularsEditedAnswerModel);*/

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_3_0_lList;
    }

    //STEP 3.1 INSERT, UPDATE AND GET DATA
    //INSERT STEP 3.1
    public long insertEntrepreneurBP_3_1_step(String landBuildingModelArrayList, Long businessplanId, Long entrepreneurId) {

        ContentValues values = new ContentValues();

        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_1_LIST_OF_LAND_BUILDINGS, landBuildingModelArrayList);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_1_BUSINESSPLAN_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_1_ENTREPRENEUR_ID, entrepreneurId);

        return mSqLiteDatabase.insert(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_1_CREATE, null, values);
    }


    //STEP 3.1 UPDATE DATA
    public long updateEntrepreneurBP_3_1_step(String landBuildingModelArrayList, Long businessplanId, Long entrepreneurId) {

        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_1_LIST_OF_LAND_BUILDINGS, landBuildingModelArrayList);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_1_BUSINESSPLAN_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_1_ENTREPRENEUR_ID, entrepreneurId);
        String whereArgs[] = new String[1];
        whereArgs[0] = "" + entrepreneurId;
        return mSqLiteDatabase.update(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_1_CREATE, values, KEY_ENTREPRENEUR_BUSINESSPLAN_3_1_ENTREPRENEUR_ID + "= ?", whereArgs);
    }

    //STEP 3.1 GET ALL DATA
    public ArrayList<LandBuildingModel> getEntrepreneurBusinessplan_step_3_1_lListALL() {
        ArrayList<LandBuildingModel> mEntrepreneurBusinessplan_step_3_1_lList = new ArrayList<>();

        try {

            result = mSqLiteDatabase.query(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_1_CREATE, new String[]{}, null, null,
                    null, null, null);


            if (result.moveToFirst()) {
                do {
                    SubmitLandBuildingData mSubmitLandBuildingData = new SubmitLandBuildingData();
                    String strLandBuildingsArrayList = result.getString(1);
                    Gson gson = new Gson();
                    TypeToken<ArrayList<LandBuildingModel>> token = new TypeToken<ArrayList<LandBuildingModel>>() {
                    };
                    ArrayList<LandBuildingModel> landBuildingsModelArrayList = gson.fromJson(strLandBuildingsArrayList, token.getType());

                    mEntrepreneurBusinessplan_step_3_1_lList = gson.fromJson(strLandBuildingsArrayList, token.getType());
                    /*mSubmitLandBuildingData.setLandBuildingExpensesList(landBuildingsModelArrayList);
                    mSubmitLandBuildingData.setBusinessPlanId(result.getLong(2));
                    mSubmitLandBuildingData.setEntrepreneurId(result.getLong(3));

                    mEntrepreneurBusinessplan_step_3_1_lList.add(mSubmitLandBuildingData);*/

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_3_1_lList;
    }

    //STEP 3.1 GET SINGLE DATA
    public ArrayList<GetNewBusinessPlanDataModel.DataBean> getEntrepreneurBusinessplan_step_3_1_lList(Long entrepreneurId) {
        ArrayList<GetNewBusinessPlanDataModel.DataBean> mEntrepreneurBusinessplan_step_3_1_lList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENEUR_BUSINESSPLAN_3_1_CREATE,
                            new String[]{
                                    KEY_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_1_LIST_OF_LAND_BUILDINGS,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_1_BUSINESSPLAN_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_1_ENTREPRENEUR_ID},

                            KEY_ENTREPRENEUR_BUSINESSPLAN_3_1_ENTREPRENEUR_ID + "=" + entrepreneurId,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {
                do {

                    GetNewBusinessPlanDataModel.DataBean mSubmitLandBuildingData = new GetNewBusinessPlanDataModel.DataBean();
                    String strLandBuildingsArrayList = result.getString(1);
                    Gson gson = new Gson();
                    TypeToken<ArrayList<GetNewBusinessPlanDataModel.DataBean.LandBuildingExpensesBean>> token = new TypeToken<ArrayList<GetNewBusinessPlanDataModel.DataBean.LandBuildingExpensesBean>>() {
                    };
                    ArrayList<GetNewBusinessPlanDataModel.DataBean.LandBuildingExpensesBean> landBuildingsModelArrayList = gson.fromJson(strLandBuildingsArrayList, token.getType());

                    mSubmitLandBuildingData.setLandBuildingExpenses(landBuildingsModelArrayList);
                    mSubmitLandBuildingData.setEntrepreneurId(result.getLong(3));

                    mEntrepreneurBusinessplan_step_3_1_lList.add(mSubmitLandBuildingData);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_3_1_lList;
    }

    //Insert new business plan  step 3.2 plant and machinery data in to database
    public Long insertBusinessPlan3_2_MachineryAddMorNeweModelList(Long KEY_NEW_BUSINESS_PLAN_STEP_3_2_ITEM_ID,
                                                                   Long KEY_NEW_BUSINESS_PLAN_STEP_3_2_BUSINESS_PLAN_ID,
                                                                   String KEY_NEW_BUSINESS_PLAN_STEP_3_2_PERTICULER,
                                                                   Long KEY_NEW_BUSINESS_PLAN_STEP_3_2_NO,
                                                                   double KEY_NEW_BUSINESS_PLAN_STEP_3_2_PRICE,
                                                                   double KEY_NEW_BUSINESS_PLAN_STEP_3_2_AMOUNT,
                                                                   Long KEY_NEW_BUSINESS_PLAN_STEP_3_2_PURCHASE_DATE,
                                                                   Long KEY_NEW_BUSINESS_PLAN_STEP_3_2_EXPECTED_LIFE,
                                                                   Long KEY_NEW_BUSINESS_PLAN_STEP_3_2_SCRAP_VALUE,
                                                                   double KEY_NEW_BUSINESS_PLAN_STEP_3_2_DEPRICIATION,
                                                                   double KEY_NEW_BUSINESS_PLAN_STEP_3_2_BOOK_VALUE,
                                                                   String KEY_NEW_BUSINESS_PLAN_STEP_3_2_SUPPLIERS_ADDRESS,
                                                                   double KEY_NEW_BUSINESS_PLAN_STEP_3_2_TAX_TRANSPORTATION,
                                                                   double KEY_NEW_BUSINESS_PLAN_STEP_3_2_ELECTRIFICATION,
                                                                   String KEY_NEW_BUSINESS_PLAN_STEP_3_2_UPLOAD_QUOTATION,
                                                                   int KEY_NEW_BUSINESS_PLAN_STEP_3_2_IS_FIELD_EDITABLE) {
        ContentValues values = new ContentValues();
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_ITEM_ID, KEY_NEW_BUSINESS_PLAN_STEP_3_2_ITEM_ID);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_BUSINESS_PLAN_ID, KEY_NEW_BUSINESS_PLAN_STEP_3_2_BUSINESS_PLAN_ID);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_PERTICULER, KEY_NEW_BUSINESS_PLAN_STEP_3_2_PERTICULER);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_NO, KEY_NEW_BUSINESS_PLAN_STEP_3_2_NO);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_PRICE, KEY_NEW_BUSINESS_PLAN_STEP_3_2_PRICE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_AMOUNT, KEY_NEW_BUSINESS_PLAN_STEP_3_2_AMOUNT);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_PURCHASE_DATE, KEY_NEW_BUSINESS_PLAN_STEP_3_2_PURCHASE_DATE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_EXPECTED_LIFE, KEY_NEW_BUSINESS_PLAN_STEP_3_2_EXPECTED_LIFE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_SCRAP_VALUE, KEY_NEW_BUSINESS_PLAN_STEP_3_2_SCRAP_VALUE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_DEPRICIATION, KEY_NEW_BUSINESS_PLAN_STEP_3_2_DEPRICIATION);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_BOOK_VALUE, KEY_NEW_BUSINESS_PLAN_STEP_3_2_BOOK_VALUE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_SUPPLIERS_ADDRESS, KEY_NEW_BUSINESS_PLAN_STEP_3_2_SUPPLIERS_ADDRESS);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_TAX_TRANSPORTATION, KEY_NEW_BUSINESS_PLAN_STEP_3_2_TAX_TRANSPORTATION);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_ELECTRIFICATION, KEY_NEW_BUSINESS_PLAN_STEP_3_2_ELECTRIFICATION);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_UPLOAD_QUOTATION, KEY_NEW_BUSINESS_PLAN_STEP_3_2_UPLOAD_QUOTATION);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_IS_FIELD_EDITABLE, KEY_NEW_BUSINESS_PLAN_STEP_3_2_IS_FIELD_EDITABLE);
        return mSqLiteDatabase.insert(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_2_CREATE, null, values);
    }

    //KETAN GET 3.2 ALL DATA
    public ArrayList<PlantAndMachineryAddMorNeweModel> getBusinessPlan3_2_MachineryAddMorNeweModelListALL() {
        ArrayList<PlantAndMachineryAddMorNeweModel> mPlantAndMachineryAddMorNeweModelList = new ArrayList<>();

        Bitmap mBitmap;
        ByteArrayOutputStream mByteArrayOutputStream;
        String filepath = "", filename = "";

        try {

            result = mSqLiteDatabase.query(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_2_CREATE, new String[]{}, null, null,
                    null, null, null);


            if (result.moveToFirst()) {
                do {
                    PlantAndMachineryAddMorNeweModel mPlantAndMachineryAddMorNeweModel = new PlantAndMachineryAddMorNeweModel();
                    mPlantAndMachineryAddMorNeweModel.setId(result.getLong(1));
                    mPlantAndMachineryAddMorNeweModel.setBusinessPlanID(result.getLong(2));
                    mPlantAndMachineryAddMorNeweModel.setPerticuler(result.getString(3));
                    mPlantAndMachineryAddMorNeweModel.setMachineryNo(result.getLong(4));
                    mPlantAndMachineryAddMorNeweModel.setPrice(result.getDouble(5));
                    mPlantAndMachineryAddMorNeweModel.setAmount(result.getDouble(6));
                    mPlantAndMachineryAddMorNeweModel.setPurchaseDate(result.getLong(7));
                    mPlantAndMachineryAddMorNeweModel.setExpectedLife(result.getLong(8));
                    mPlantAndMachineryAddMorNeweModel.setScrapValue(result.getLong(9));
                    mPlantAndMachineryAddMorNeweModel.setDepriciation(result.getDouble(10));
                    mPlantAndMachineryAddMorNeweModel.setBookValue(result.getDouble(11));
                    mPlantAndMachineryAddMorNeweModel.setSuppliersNameAndAddress(result.getString(12));
                    mPlantAndMachineryAddMorNeweModel.setTaxTransporatation(result.getDouble(13));
                    mPlantAndMachineryAddMorNeweModel.setElectrification(result.getDouble(14));


                    mBitmap = BitmapFactory.decodeFile(result.getString(15));
                    mByteArrayOutputStream = new ByteArrayOutputStream();
                    mBitmap.compress(Bitmap.CompressFormat.JPEG, 10, mByteArrayOutputStream);
                    mPlantAndMachineryAddMorNeweModel.setFile(mByteArrayOutputStream.toByteArray());

                    // mPlantAndMachineryAddMorNeweModel.setUploadQuotaion(result.getString(15));

                    mPlantAndMachineryAddMorNeweModel.setIsDataEditable(result.getInt(16));
                    mPlantAndMachineryAddMorNeweModelList.add(mPlantAndMachineryAddMorNeweModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }
        return mPlantAndMachineryAddMorNeweModelList;
    }

    public ArrayList<GetNewBusinessPlanDataModel.DataBean.PlantAndMachineriesBean> getBusinessPlan3_2_MachineryAddMorNeweModelList(Long BusinessPlanID) {
        ArrayList<GetNewBusinessPlanDataModel.DataBean.PlantAndMachineriesBean> mPlantAndMachineryAddMorNeweModelList = new ArrayList<>();
        Bitmap mBitmap;
        ByteArrayOutputStream mByteArrayOutputStream;
        String filepath = "", filename = "";
        try {

            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENEUR_BUSINESSPLAN_3_2_CREATE,
                            new String[]{
                                    KEY_ID,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_ITEM_ID,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_BUSINESS_PLAN_ID,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_PERTICULER,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_NO,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_PRICE,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_AMOUNT,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_PURCHASE_DATE,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_EXPECTED_LIFE,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_SCRAP_VALUE,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_DEPRICIATION,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_BOOK_VALUE,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_SUPPLIERS_ADDRESS,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_TAX_TRANSPORTATION,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_ELECTRIFICATION,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_UPLOAD_QUOTATION,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_IS_FIELD_EDITABLE
                            },
                            KEY_NEW_BUSINESS_PLAN_STEP_3_2_BUSINESS_PLAN_ID + "=" + BusinessPlanID,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {
                do {
                    GetNewBusinessPlanDataModel.DataBean.PlantAndMachineriesBean mPlantAndMachineryAddMorNeweModel = new GetNewBusinessPlanDataModel.DataBean.PlantAndMachineriesBean();
                    mPlantAndMachineryAddMorNeweModel.setId(result.getLong(1));
                    mPlantAndMachineryAddMorNeweModel.setBusinessPlanID(result.getLong(2));
                    mPlantAndMachineryAddMorNeweModel.setPerticuler(result.getString(3));
                    mPlantAndMachineryAddMorNeweModel.setMachineryNo(result.getLong(4));
                    mPlantAndMachineryAddMorNeweModel.setPrice(result.getDouble(5));
                    mPlantAndMachineryAddMorNeweModel.setAmount(result.getDouble(6));
                    mPlantAndMachineryAddMorNeweModel.setPurchaseDate(result.getLong(7));
                    mPlantAndMachineryAddMorNeweModel.setExpectedLife(result.getLong(8));
                    mPlantAndMachineryAddMorNeweModel.setScrapValue(result.getLong(9));
                    mPlantAndMachineryAddMorNeweModel.setDepriciation(result.getDouble(10));
                    mPlantAndMachineryAddMorNeweModel.setBookValue(result.getDouble(11));
                    mPlantAndMachineryAddMorNeweModel.setSuppliersNameAndAddress(result.getString(12));
                    mPlantAndMachineryAddMorNeweModel.setTaxTransporatation(result.getDouble(13));
                    mPlantAndMachineryAddMorNeweModel.setElectrification(result.getDouble(14));
                    // mPlantAndMachineryAddMorNeweModel.setUploadQuotation(result.getString(15));

                    if(!result.getString(15).equals("")) {
                        mBitmap = BitmapFactory.decodeFile(result.getString(15));
                        mByteArrayOutputStream = new ByteArrayOutputStream();
                        mBitmap.compress(Bitmap.CompressFormat.JPEG, 10, mByteArrayOutputStream);
                        mPlantAndMachineryAddMorNeweModel.setFile(mByteArrayOutputStream.toByteArray());
                    }else {
                        mPlantAndMachineryAddMorNeweModel.setFile(null);
                    }

                    mPlantAndMachineryAddMorNeweModel.setIsDataEditable(result.getInt(16));
                    mPlantAndMachineryAddMorNeweModelList.add(mPlantAndMachineryAddMorNeweModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }
        return mPlantAndMachineryAddMorNeweModelList;
    }

    public ArrayList<GetNewBusinessPlanDataModel.DataBean.PlantAndMachineriesBean> getBusinessPlan3_2_MachineryAddMorNeweModelListForUploadBuisinessPlan(Long BusinessPlanID) {
        ArrayList<GetNewBusinessPlanDataModel.DataBean.PlantAndMachineriesBean> mPlantAndMachineryAddMorNeweModelList = new ArrayList<>();


        Bitmap mBitmap;
        ByteArrayOutputStream mByteArrayOutputStream;
        String filepath = "", filename = "";

        try {

            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENEUR_BUSINESSPLAN_3_2_CREATE,
                            new String[]{
                                    KEY_ID,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_ITEM_ID,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_BUSINESS_PLAN_ID,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_PERTICULER,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_NO,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_PRICE,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_AMOUNT,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_PURCHASE_DATE,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_EXPECTED_LIFE,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_SCRAP_VALUE,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_DEPRICIATION,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_BOOK_VALUE,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_SUPPLIERS_ADDRESS,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_TAX_TRANSPORTATION,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_ELECTRIFICATION,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_UPLOAD_QUOTATION,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_2_IS_FIELD_EDITABLE
                            },
                            KEY_NEW_BUSINESS_PLAN_STEP_3_2_BUSINESS_PLAN_ID + "=" + BusinessPlanID,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {
                do {
                    GetNewBusinessPlanDataModel.DataBean.PlantAndMachineriesBean mPlantAndMachineryAddMorNeweModel = new GetNewBusinessPlanDataModel.DataBean.PlantAndMachineriesBean();
                    mPlantAndMachineryAddMorNeweModel.setId(result.getLong(1));
                    mPlantAndMachineryAddMorNeweModel.setBusinessPlanID(result.getLong(2));
                    mPlantAndMachineryAddMorNeweModel.setPerticuler(result.getString(3));
                    mPlantAndMachineryAddMorNeweModel.setMachineryNo(result.getLong(4));
                    mPlantAndMachineryAddMorNeweModel.setPrice(result.getDouble(5));
                    mPlantAndMachineryAddMorNeweModel.setAmount(result.getDouble(6));
                    mPlantAndMachineryAddMorNeweModel.setPurchaseDate(result.getLong(7));
                    mPlantAndMachineryAddMorNeweModel.setExpectedLife(result.getLong(8));
                    mPlantAndMachineryAddMorNeweModel.setScrapValue(result.getLong(9));
                    mPlantAndMachineryAddMorNeweModel.setDepriciation(result.getDouble(10));
                    mPlantAndMachineryAddMorNeweModel.setBookValue(result.getDouble(11));
                    mPlantAndMachineryAddMorNeweModel.setSuppliersNameAndAddress(result.getString(12));
                    mPlantAndMachineryAddMorNeweModel.setTaxTransporatation(result.getDouble(13));
                    mPlantAndMachineryAddMorNeweModel.setElectrification(result.getDouble(14));
                    // mPlantAndMachineryAddMorNeweModel.setUploadQuotation(result.getString(15));
                    mBitmap = BitmapFactory.decodeFile(result.getString(15));
                    mByteArrayOutputStream = new ByteArrayOutputStream();
                    mBitmap.compress(Bitmap.CompressFormat.JPEG, 10, mByteArrayOutputStream);
                    mPlantAndMachineryAddMorNeweModel.setFile(mByteArrayOutputStream.toByteArray());

                    mPlantAndMachineryAddMorNeweModel.setIsDataEditable(result.getInt(16));
                    mPlantAndMachineryAddMorNeweModelList.add(mPlantAndMachineryAddMorNeweModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }
        return mPlantAndMachineryAddMorNeweModelList;
    }

    //update Business Plan producation and revenue list item.
    public int updateBusinessPlan3_2_MachineryAddMorNeweModelList(Long KEY_NEW_BUSINESS_PLAN_STEP_3_2_ITEM_ID,
                                                                  Long KEY_NEW_BUSINESS_PLAN_STEP_3_2_BUSINESS_PLAN_ID,
                                                                  String KEY_NEW_BUSINESS_PLAN_STEP_3_2_PERTICULER,
                                                                  Long KEY_NEW_BUSINESS_PLAN_STEP_3_2_NO,
                                                                  double KEY_NEW_BUSINESS_PLAN_STEP_3_2_PRICE,
                                                                  double KEY_NEW_BUSINESS_PLAN_STEP_3_2_AMOUNT,
                                                                  Long KEY_NEW_BUSINESS_PLAN_STEP_3_2_PURCHASE_DATE,
                                                                  Long KEY_NEW_BUSINESS_PLAN_STEP_3_2_EXPECTED_LIFE,
                                                                  Long KEY_NEW_BUSINESS_PLAN_STEP_3_2_SCRAP_VALUE,
                                                                  double KEY_NEW_BUSINESS_PLAN_STEP_3_2_DEPRICIATION,
                                                                  double KEY_NEW_BUSINESS_PLAN_STEP_3_2_BOOK_VALUE,
                                                                  String KEY_NEW_BUSINESS_PLAN_STEP_3_2_SUPPLIERS_ADDRESS,
                                                                  double KEY_NEW_BUSINESS_PLAN_STEP_3_2_TAX_TRANSPORTATION,
                                                                  double KEY_NEW_BUSINESS_PLAN_STEP_3_2_ELECTRIFICATION,
                                                                  String KEY_NEW_BUSINESS_PLAN_STEP_3_2_UPLOAD_QUOTATION,
                                                                  int KEY_NEW_BUSINESS_PLAN_STEP_3_2_IS_FIELD_EDITABLE


    ) {
        ContentValues values = new ContentValues();
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_ITEM_ID, KEY_NEW_BUSINESS_PLAN_STEP_3_2_ITEM_ID);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_BUSINESS_PLAN_ID, KEY_NEW_BUSINESS_PLAN_STEP_3_2_BUSINESS_PLAN_ID);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_PERTICULER, KEY_NEW_BUSINESS_PLAN_STEP_3_2_PERTICULER);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_NO, KEY_NEW_BUSINESS_PLAN_STEP_3_2_NO);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_PRICE, KEY_NEW_BUSINESS_PLAN_STEP_3_2_PRICE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_AMOUNT, KEY_NEW_BUSINESS_PLAN_STEP_3_2_AMOUNT);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_PURCHASE_DATE, KEY_NEW_BUSINESS_PLAN_STEP_3_2_PURCHASE_DATE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_EXPECTED_LIFE, KEY_NEW_BUSINESS_PLAN_STEP_3_2_EXPECTED_LIFE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_SCRAP_VALUE, KEY_NEW_BUSINESS_PLAN_STEP_3_2_SCRAP_VALUE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_DEPRICIATION, KEY_NEW_BUSINESS_PLAN_STEP_3_2_DEPRICIATION);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_BOOK_VALUE, KEY_NEW_BUSINESS_PLAN_STEP_3_2_BOOK_VALUE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_SUPPLIERS_ADDRESS, KEY_NEW_BUSINESS_PLAN_STEP_3_2_SUPPLIERS_ADDRESS);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_TAX_TRANSPORTATION, KEY_NEW_BUSINESS_PLAN_STEP_3_2_TAX_TRANSPORTATION);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_ELECTRIFICATION, KEY_NEW_BUSINESS_PLAN_STEP_3_2_ELECTRIFICATION);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_UPLOAD_QUOTATION, KEY_NEW_BUSINESS_PLAN_STEP_3_2_UPLOAD_QUOTATION);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_IS_FIELD_EDITABLE, KEY_NEW_BUSINESS_PLAN_STEP_3_2_IS_FIELD_EDITABLE);
        return mSqLiteDatabase.update(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_2_CREATE, values, this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_ITEM_ID + "=" + KEY_NEW_BUSINESS_PLAN_STEP_3_2_ITEM_ID, null);
    }

    public int deleteBusinessPlan3_2_MachineryAddMorNeweModelList(Long KEY_NEW_BUSINESS_PLAN_ITEM_ID) {
        return mSqLiteDatabase.delete(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_2_CREATE, this.KEY_NEW_BUSINESS_PLAN_STEP_3_2_ITEM_ID + "= ?", new String[]{"" + KEY_NEW_BUSINESS_PLAN_ITEM_ID});
    }




    public int deleteNewBusinessPlan20ProductionAndRevenueData(Long KEY_NEW_BUSINESS_PLAN_ITEM_ID) {
        return mSqLiteDatabase.delete(TABLE_NEW_BUSINESS_PLAN_DATA, this.KEY_NEW_BUSINESS_PLAN_ITEM_ID + "= ?", new String[]{"" + KEY_NEW_BUSINESS_PLAN_ITEM_ID});
    }

    //INSERT UPDATE NEW BUSINESS PLAN STEP  3.3 FURNITURE DATA
    public Long insertBusinessPlan3_3_FurnitureAddMorNeweModelList(Long KEY_NEW_BUSINESS_PLAN_STEP_3_3_ITEM_ID,
                                                                   Long KEY_NEW_BUSINESS_PLAN_STEP_3_3_BUSINESS_PLAN_ID,
                                                                   String KEY_NEW_BUSINESS_PLAN_STEP_3_3_PERTICULER,
                                                                   Long KEY_NEW_BUSINESS_PLAN_STEP_3_3_NO,
                                                                   double KEY_NEW_BUSINESS_PLAN_STEP_3_3_PRICE,
                                                                   double KEY_NEW_BUSINESS_PLAN_STEP_3_3_AMOUNT,
                                                                   Long KEY_NEW_BUSINESS_PLAN_STEP_3_3_PURCHASE_DATE,
                                                                   Long KEY_NEW_BUSINESS_PLAN_STEP_3_3_EXPECTED_LIFE,
                                                                   Long KEY_NEW_BUSINESS_PLAN_STEP_3_3_SCRAP_VALUE,
                                                                   double KEY_NEW_BUSINESS_PLAN_STEP_3_3_DEPRICIATION,
                                                                   double KEY_NEW_BUSINESS_PLAN_STEP_3_3_BOOK_VALUE,
                                                                   String KEY_NEW_BUSINESS_PLAN_STEP_3_3_SUPPLIERS_ADDRESS,
                                                                   String KEY_NEW_BUSINESS_PLAN_STEP_3_3_UPLOAD_QUPTATIONS,
                                                                   int KEY_NEW_BUSINESS_PLAN_STEP_3_3_IS_FIELD_EDITABLE


    ) {
        ContentValues values = new ContentValues();
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_ITEM_ID, KEY_NEW_BUSINESS_PLAN_STEP_3_3_ITEM_ID);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_BUSINESS_PLAN_ID, KEY_NEW_BUSINESS_PLAN_STEP_3_3_BUSINESS_PLAN_ID);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_PERTICULER, KEY_NEW_BUSINESS_PLAN_STEP_3_3_PERTICULER);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_NO, KEY_NEW_BUSINESS_PLAN_STEP_3_3_NO);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_PRICE, KEY_NEW_BUSINESS_PLAN_STEP_3_3_PRICE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_AMOUNT, KEY_NEW_BUSINESS_PLAN_STEP_3_3_AMOUNT);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_PURCHASE_DATE, KEY_NEW_BUSINESS_PLAN_STEP_3_3_PURCHASE_DATE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_EXPECTED_LIFE, KEY_NEW_BUSINESS_PLAN_STEP_3_3_EXPECTED_LIFE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_SCRAP_VALUE, KEY_NEW_BUSINESS_PLAN_STEP_3_3_SCRAP_VALUE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_DEPRICIATION, KEY_NEW_BUSINESS_PLAN_STEP_3_3_DEPRICIATION);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_BOOK_VALUE, KEY_NEW_BUSINESS_PLAN_STEP_3_3_BOOK_VALUE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_SUPPLIERS_ADDRESS, KEY_NEW_BUSINESS_PLAN_STEP_3_3_SUPPLIERS_ADDRESS);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_UPLOAD_QUPTATIONS, KEY_NEW_BUSINESS_PLAN_STEP_3_3_UPLOAD_QUPTATIONS);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_IS_FIELD_EDITABLE, KEY_NEW_BUSINESS_PLAN_STEP_3_3_IS_FIELD_EDITABLE);
        return mSqLiteDatabase.insert(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_3_CREATE, null, values);
    }

    //KETAN GET 3.3 ALL DATA
    public ArrayList<NewBusinessPlanFurnitureStep3_3Model> getBusinessPlan3_3_FurnitureAddMorNeweModelListALL() {
        ArrayList<NewBusinessPlanFurnitureStep3_3Model> mNewBusinessPlanFurnitureStep3_3ModelList = new ArrayList<>();

        try {

            result = mSqLiteDatabase.query(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_3_CREATE, new String[]{}, null, null,
                    null, null, null);
            if (result.moveToFirst()) {
                do {
                    NewBusinessPlanFurnitureStep3_3Model mNewBusinessPlanFurnitureStep3_3Model = new NewBusinessPlanFurnitureStep3_3Model();
                    mNewBusinessPlanFurnitureStep3_3Model.setId(result.getLong(1));
                    mNewBusinessPlanFurnitureStep3_3Model.setBusinessPlanID(result.getLong(2));
                    mNewBusinessPlanFurnitureStep3_3Model.setPerticuler(result.getString(3));
                    mNewBusinessPlanFurnitureStep3_3Model.setMachineryNo(result.getLong(4));
                    mNewBusinessPlanFurnitureStep3_3Model.setPrice(result.getDouble(5));
                    mNewBusinessPlanFurnitureStep3_3Model.setAmount(result.getDouble(6));
                    mNewBusinessPlanFurnitureStep3_3Model.setPurchaseDate(result.getLong(7));
                    mNewBusinessPlanFurnitureStep3_3Model.setExpectedLife(result.getLong(8));
                    mNewBusinessPlanFurnitureStep3_3Model.setScrapValue(result.getLong(9));
                    mNewBusinessPlanFurnitureStep3_3Model.setDepriciation(result.getDouble(10));
                    mNewBusinessPlanFurnitureStep3_3Model.setBookValue(result.getDouble(11));
                    mNewBusinessPlanFurnitureStep3_3Model.setSuppliersNameAndAddress(result.getString(12));
                    mNewBusinessPlanFurnitureStep3_3Model.setIsDataEditable(result.getInt(13));
                    mNewBusinessPlanFurnitureStep3_3ModelList.add(mNewBusinessPlanFurnitureStep3_3Model);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }
        return mNewBusinessPlanFurnitureStep3_3ModelList;
    }

    public ArrayList<GetNewBusinessPlanDataModel.DataBean.FurnituresBean> getBusinessPlan3_3_FurnitureAddMorNeweModelList(Long BusinessPlanID) {
        ArrayList<GetNewBusinessPlanDataModel.DataBean.FurnituresBean> mNewBusinessPlanFurnitureStep3_3ModelList = new ArrayList<>();


        Bitmap mBitmap;
        ByteArrayOutputStream mByteArrayOutputStream;
        String filepath = "", filename = "";
        try {

            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENEUR_BUSINESSPLAN_3_3_CREATE,
                            new String[]{
                                    KEY_ID,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_3_ITEM_ID,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_3_BUSINESS_PLAN_ID,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_3_PERTICULER,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_3_NO,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_3_PRICE,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_3_AMOUNT,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_3_PURCHASE_DATE,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_3_EXPECTED_LIFE,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_3_SCRAP_VALUE,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_3_DEPRICIATION,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_3_BOOK_VALUE,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_3_SUPPLIERS_ADDRESS,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_3_UPLOAD_QUPTATIONS,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_3_IS_FIELD_EDITABLE
                            },
                            KEY_NEW_BUSINESS_PLAN_STEP_3_3_BUSINESS_PLAN_ID + "=" + BusinessPlanID,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {
                do {
                    GetNewBusinessPlanDataModel.DataBean.FurnituresBean mNewBusinessPlanFurnitureStep3_3Model = new GetNewBusinessPlanDataModel.DataBean.FurnituresBean();
                    mNewBusinessPlanFurnitureStep3_3Model.setId(result.getLong(1));
                    mNewBusinessPlanFurnitureStep3_3Model.setBusinessPlanID(result.getLong(2));
                    mNewBusinessPlanFurnitureStep3_3Model.setPerticuler(result.getString(3));
                    mNewBusinessPlanFurnitureStep3_3Model.setMachineryNo(result.getLong(4));
                    mNewBusinessPlanFurnitureStep3_3Model.setPrice(result.getDouble(5));
                    mNewBusinessPlanFurnitureStep3_3Model.setAmount(result.getDouble(6));
                    mNewBusinessPlanFurnitureStep3_3Model.setPurchaseDate(result.getLong(7));
                    mNewBusinessPlanFurnitureStep3_3Model.setExpectedLife(result.getLong(8));
                    mNewBusinessPlanFurnitureStep3_3Model.setScrapValue(result.getLong(9));
                    mNewBusinessPlanFurnitureStep3_3Model.setDepriciation(result.getDouble(10));
                    mNewBusinessPlanFurnitureStep3_3Model.setBookValue(result.getDouble(11));
                    mNewBusinessPlanFurnitureStep3_3Model.setSuppliersNameAndAddress(result.getString(12));
                    //AlertUtils.loge("FILENAME : "+result.getString(13));
                    if(!result.getString(13).equals("")) {
                        mBitmap = BitmapFactory.decodeFile(result.getString(13));
                        mByteArrayOutputStream = new ByteArrayOutputStream();
                        mBitmap.compress(Bitmap.CompressFormat.JPEG, 10, mByteArrayOutputStream);
                        mNewBusinessPlanFurnitureStep3_3Model.setFile(mByteArrayOutputStream.toByteArray());
                    }else{
                        mNewBusinessPlanFurnitureStep3_3Model.setFile(null);
                    }


                    mNewBusinessPlanFurnitureStep3_3Model.setIsDataEditable(result.getInt(14));
                    mNewBusinessPlanFurnitureStep3_3ModelList.add(mNewBusinessPlanFurnitureStep3_3Model);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }
        return mNewBusinessPlanFurnitureStep3_3ModelList;
    }

    //update Business Plan step 3.3 Furniture list item.
    public int updateBusinessPlan3_3_FurnitureAddMorNeweModelList(Long KEY_NEW_BUSINESS_PLAN_STEP_3_3_ITEM_ID,
                                                                  Long KEY_NEW_BUSINESS_PLAN_STEP_3_3_BUSINESS_PLAN_ID,
                                                                  String KEY_NEW_BUSINESS_PLAN_STEP_3_3_PERTICULER,
                                                                  Long KEY_NEW_BUSINESS_PLAN_STEP_3_3_NO,
                                                                  double KEY_NEW_BUSINESS_PLAN_STEP_3_3_PRICE,
                                                                  double KEY_NEW_BUSINESS_PLAN_STEP_3_3_AMOUNT,
                                                                  Long KEY_NEW_BUSINESS_PLAN_STEP_3_3_PURCHASE_DATE,
                                                                  Long KEY_NEW_BUSINESS_PLAN_STEP_3_3_EXPECTED_LIFE,
                                                                  Long KEY_NEW_BUSINESS_PLAN_STEP_3_3_SCRAP_VALUE,
                                                                  double KEY_NEW_BUSINESS_PLAN_STEP_3_3_DEPRICIATION,
                                                                  double KEY_NEW_BUSINESS_PLAN_STEP_3_3_BOOK_VALUE,
                                                                  String KEY_NEW_BUSINESS_PLAN_STEP_3_3_SUPPLIERS_ADDRESS,
                                                                  String KEY_NEW_BUSINESS_PLAN_STEP_3_3_UPLOAD_QUPTATIONS,
                                                                  int KEY_NEW_BUSINESS_PLAN_STEP_3_3_IS_FIELD_EDITABLE


    ) {
        ContentValues values = new ContentValues();
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_ITEM_ID, KEY_NEW_BUSINESS_PLAN_STEP_3_3_ITEM_ID);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_BUSINESS_PLAN_ID, KEY_NEW_BUSINESS_PLAN_STEP_3_3_BUSINESS_PLAN_ID);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_PERTICULER, KEY_NEW_BUSINESS_PLAN_STEP_3_3_PERTICULER);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_NO, KEY_NEW_BUSINESS_PLAN_STEP_3_3_NO);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_PRICE, KEY_NEW_BUSINESS_PLAN_STEP_3_3_PRICE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_AMOUNT, KEY_NEW_BUSINESS_PLAN_STEP_3_3_AMOUNT);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_PURCHASE_DATE, KEY_NEW_BUSINESS_PLAN_STEP_3_3_PURCHASE_DATE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_EXPECTED_LIFE, KEY_NEW_BUSINESS_PLAN_STEP_3_3_EXPECTED_LIFE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_SCRAP_VALUE, KEY_NEW_BUSINESS_PLAN_STEP_3_3_SCRAP_VALUE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_DEPRICIATION, KEY_NEW_BUSINESS_PLAN_STEP_3_3_DEPRICIATION);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_BOOK_VALUE, KEY_NEW_BUSINESS_PLAN_STEP_3_3_BOOK_VALUE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_SUPPLIERS_ADDRESS, KEY_NEW_BUSINESS_PLAN_STEP_3_3_SUPPLIERS_ADDRESS);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_UPLOAD_QUPTATIONS, KEY_NEW_BUSINESS_PLAN_STEP_3_3_UPLOAD_QUPTATIONS);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_IS_FIELD_EDITABLE, KEY_NEW_BUSINESS_PLAN_STEP_3_3_IS_FIELD_EDITABLE);
        return mSqLiteDatabase.update(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_3_CREATE, values, this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_ITEM_ID + "=" + KEY_NEW_BUSINESS_PLAN_STEP_3_3_ITEM_ID, null);
    }


    public int deleteBusinessPlan3_3_FurnitureAddMorNeweModelList(Long KEY_NEW_BUSINESS_PLAN_STEP_3_3_ITEM_ID) {
        return mSqLiteDatabase.delete(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_3_CREATE, this.KEY_NEW_BUSINESS_PLAN_STEP_3_3_ITEM_ID + "= ?", new String[]{"" + KEY_NEW_BUSINESS_PLAN_STEP_3_3_ITEM_ID});
    }

    //INSERT UPDATE NEW BUSINESS PLAN STEP  3.4 RAW MATERIEL DATA
    public Long insertBusinessPlan3_4_RawMeterielAddMoreModelList(Long KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEM_ID,
                                                                  Long KEY_NEW_BUSINESS_PLAN_STEP_3_4_BUSINESS_PLAN_ID,
                                                                  String KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEMS,
                                                                  Long KEY_NEW_BUSINESS_PLAN_STEP_3_4_FOR_MONTHS,
                                                                  double KEY_NEW_BUSINESS_PLAN_STEP_3_4_QUANTITY_PER_UNIT,
                                                                  double KEY_NEW_BUSINESS_PLAN_STEP_3_4_UNIT_RATE,
                                                                  double KEY_NEW_BUSINESS_PLAN_STEP_3_4_TOTAL_RATE,
                                                                  int KEY_NEW_BUSINESS_PLAN_STEP_3_4_IS_FIELD_EDITABLE


    ) {
        ContentValues values = new ContentValues();
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEM_ID, KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEM_ID);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_4_BUSINESS_PLAN_ID, KEY_NEW_BUSINESS_PLAN_STEP_3_4_BUSINESS_PLAN_ID);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEMS, KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEMS);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_4_FOR_MONTHS, KEY_NEW_BUSINESS_PLAN_STEP_3_4_FOR_MONTHS);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_4_QUANTITY_PER_UNIT, KEY_NEW_BUSINESS_PLAN_STEP_3_4_QUANTITY_PER_UNIT);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_4_UNIT_RATE, KEY_NEW_BUSINESS_PLAN_STEP_3_4_UNIT_RATE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_4_TOTAL_RATE, KEY_NEW_BUSINESS_PLAN_STEP_3_4_TOTAL_RATE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_4_IS_FIELD_EDITABLE, KEY_NEW_BUSINESS_PLAN_STEP_3_4_IS_FIELD_EDITABLE);
        return mSqLiteDatabase.insert(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_4_CREATE, null, values);
    }

    //KETAN GET 3.4 ALL DATA
    public ArrayList<RawMaterialModel> getBusinessPlan3_4_RawMeterielAddMoreModelListALL() {
        ArrayList<RawMaterialModel> mRawMaterialModelList = new ArrayList<>();

        try {


            result = mSqLiteDatabase.query(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_4_CREATE, new String[]{}, null, null,
                    null, null, null);

            if (result.moveToFirst()) {
                do {
                    RawMaterialModel mRawMaterialModelModel = new RawMaterialModel();
                    mRawMaterialModelModel.setId(result.getLong(1));
                    mRawMaterialModelModel.setBusinessPlanId(result.getLong(2));
                    mRawMaterialModelModel.setItem(result.getString(3));
                    mRawMaterialModelModel.setForMonths(result.getInt(4));
                    mRawMaterialModelModel.setQuantity(result.getLong(5));
                    mRawMaterialModelModel.setRate(result.getDouble(6));
                    mRawMaterialModelModel.setTotalValue(result.getDouble(7));
                    mRawMaterialModelModel.setIsEditable(result.getInt(8));
                    mRawMaterialModelList.add(mRawMaterialModelModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }
        return mRawMaterialModelList;
    }


    public ArrayList<GetNewBusinessPlanDataModel.DataBean.RawMaterialsBean> getBusinessPlan3_4_RawMeterielAddMoreModelList(Long BusinessPlanID) {
        ArrayList<GetNewBusinessPlanDataModel.DataBean.RawMaterialsBean> mRawMaterialModelList = new ArrayList<>();

        try {

            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENEUR_BUSINESSPLAN_3_4_CREATE,
                            new String[]{
                                    KEY_ID,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEM_ID,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_4_BUSINESS_PLAN_ID,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEMS,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_4_FOR_MONTHS,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_4_QUANTITY_PER_UNIT,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_4_UNIT_RATE,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_4_TOTAL_RATE,
                                    KEY_NEW_BUSINESS_PLAN_STEP_3_4_IS_FIELD_EDITABLE
                            },
                            KEY_NEW_BUSINESS_PLAN_STEP_3_4_BUSINESS_PLAN_ID + "=" + BusinessPlanID,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {
                do {
                    GetNewBusinessPlanDataModel.DataBean.RawMaterialsBean mRawMaterialModelModel = new GetNewBusinessPlanDataModel.DataBean.RawMaterialsBean();
                    mRawMaterialModelModel.setId(result.getLong(1));
                    mRawMaterialModelModel.setBusinessPlanId(result.getLong(2));
                    mRawMaterialModelModel.setItem(result.getString(3));
                    mRawMaterialModelModel.setForMonths(result.getLong(4));
                    mRawMaterialModelModel.setQuantity(result.getLong(5));
                    mRawMaterialModelModel.setRate(result.getDouble(6));
                    mRawMaterialModelModel.setTotalValue(result.getDouble(7));
                    mRawMaterialModelModel.setIsEditable(result.getInt(8));
                    mRawMaterialModelList.add(mRawMaterialModelModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }
        return mRawMaterialModelList;
    }

    //update Business Plan step 3.3 Furniture list item.
    public int updateBusinessPlan3_4_RawMeterielAddMoreModelList(Long KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEM_ID,
                                                                 Long KEY_NEW_BUSINESS_PLAN_STEP_3_4_BUSINESS_PLAN_ID,
                                                                 String KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEMS,
                                                                 Long KEY_NEW_BUSINESS_PLAN_STEP_3_4_FOR_MONTHS,
                                                                 double KEY_NEW_BUSINESS_PLAN_STEP_3_4_QUANTITY_PER_UNIT,
                                                                 double KEY_NEW_BUSINESS_PLAN_STEP_3_4_UNIT_RATE,
                                                                 double KEY_NEW_BUSINESS_PLAN_STEP_3_4_TOTAL_RATE,
                                                                 int KEY_NEW_BUSINESS_PLAN_STEP_3_4_IS_FIELD_EDITABLE


    ) {
        ContentValues values = new ContentValues();
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEM_ID, KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEM_ID);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_4_BUSINESS_PLAN_ID, KEY_NEW_BUSINESS_PLAN_STEP_3_4_BUSINESS_PLAN_ID);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEMS, KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEMS);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_4_FOR_MONTHS, KEY_NEW_BUSINESS_PLAN_STEP_3_4_FOR_MONTHS);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_4_QUANTITY_PER_UNIT, KEY_NEW_BUSINESS_PLAN_STEP_3_4_QUANTITY_PER_UNIT);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_4_UNIT_RATE, KEY_NEW_BUSINESS_PLAN_STEP_3_4_UNIT_RATE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_4_TOTAL_RATE, KEY_NEW_BUSINESS_PLAN_STEP_3_4_TOTAL_RATE);
        values.put(this.KEY_NEW_BUSINESS_PLAN_STEP_3_4_IS_FIELD_EDITABLE, KEY_NEW_BUSINESS_PLAN_STEP_3_4_IS_FIELD_EDITABLE);
        return mSqLiteDatabase.update(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_4_CREATE, values, this.KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEM_ID + "=" + KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEM_ID, null);
    }

    public int deleteBusinessPlan3_4_RawMeterielAddMoreModelList(Long KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEM_ID) {
        return mSqLiteDatabase.delete(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_4_CREATE, this.KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEM_ID + "= ?", new String[]{"" + KEY_NEW_BUSINESS_PLAN_STEP_3_4_ITEM_ID});
    }

    //STEP 3.5 INSERYT, UPDATE AND DELETE
    public long insertEntrepreneurBP_3_5_step(String utilitiesModelArrayList, Long businessplanId, Long entrepreneurId) {

        ContentValues values = new ContentValues();

        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_5_LIST_OF_UTILITIES, utilitiesModelArrayList);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_5_BUSINESSPLAN_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_5_ENTREPRENEUR_ID, entrepreneurId);

        return mSqLiteDatabase.insert(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_5_CREATE, null, values);
    }

    //STEP 3.5 UPDATE DATA
    public long updateEntrepreneurBP_3_5_step(String utilitiesModelArrayList, Long businessplanId, Long entrepreneurId) {

        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_5_LIST_OF_UTILITIES, utilitiesModelArrayList);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_5_BUSINESSPLAN_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_5_ENTREPRENEUR_ID, entrepreneurId);
        String whereArgs[] = new String[1];
        whereArgs[0] = "" + entrepreneurId;
        return mSqLiteDatabase.update(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_5_CREATE, values, KEY_ENTREPRENEUR_BUSINESSPLAN_3_5_ENTREPRENEUR_ID + "= ?", whereArgs);
    }

    //STEP 3.5 GET ALL DATA
    public ArrayList<WorkExperienceDTOModel> getEntrepreneurBusinessplan_step_3_5_lListALL() {
        ArrayList<WorkExperienceDTOModel> mEntrepreneurBusinessplan_step_3_5_lList = new ArrayList<>();

        try {

            result = mSqLiteDatabase.query(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_5_CREATE, new String[]{}, null, null,
                    null, null, null);


            if (result.moveToFirst()) {
                do {
                    WorkExperienceDTOModel mWorkExperienceDTOModel = new WorkExperienceDTOModel();
                    String strUtilitiesArrayList = result.getString(1);
                    Gson gson = new Gson();
                    TypeToken<ArrayList<UtilitiesModel>> token = new TypeToken<ArrayList<UtilitiesModel>>() {
                    };
                    ArrayList<UtilitiesModel> utilitiesModelArrayList = gson.fromJson(strUtilitiesArrayList, token.getType());

                    mWorkExperienceDTOModel.setUtilitiesList(utilitiesModelArrayList);
                    mWorkExperienceDTOModel.setBusinessPlanId(result.getLong(2));
                    mWorkExperienceDTOModel.setEntrepreneurId(result.getLong(3));

                    mEntrepreneurBusinessplan_step_3_5_lList.add(mWorkExperienceDTOModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_3_5_lList;
    }

    //STEP 3.5 GET SINGLE DATA
    public ArrayList<GetNewBusinessPlanDataModel.DataBean> getEntrepreneurBusinessplan_step_3_5_lList(Long entrepreneurId) {
        ArrayList<GetNewBusinessPlanDataModel.DataBean> mEntrepreneurBusinessplan_step_3_5_lList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENEUR_BUSINESSPLAN_3_5_CREATE
                            ,
                            new String[]{
                                    KEY_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_5_LIST_OF_UTILITIES,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_5_BUSINESSPLAN_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_5_ENTREPRENEUR_ID},

                            KEY_ENTREPRENEUR_BUSINESSPLAN_3_5_ENTREPRENEUR_ID + "=" + entrepreneurId,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {
                do {
                    GetNewBusinessPlanDataModel.DataBean mWorkExperienceDTOModel = new GetNewBusinessPlanDataModel.DataBean();
                    String strUtilitiesArrayList = result.getString(1);
                    Gson gson = new Gson();
                    TypeToken<ArrayList<GetNewBusinessPlanDataModel.DataBean.UtilitiesBean>> token = new TypeToken<ArrayList<GetNewBusinessPlanDataModel.DataBean.UtilitiesBean>>() {
                    };
                    ArrayList<GetNewBusinessPlanDataModel.DataBean.UtilitiesBean> utilitiesModelArrayList = gson.fromJson(strUtilitiesArrayList, token.getType());

                    mWorkExperienceDTOModel.setUtilities(utilitiesModelArrayList);
                    mWorkExperienceDTOModel.setEntrepreneurId(result.getLong(3));

                    mEntrepreneurBusinessplan_step_3_5_lList.add(mWorkExperienceDTOModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_3_5_lList;
    }

    //STEP 3.6 INSERT, UPDATE AND DELETE
    public long insertEntrepreneurBP_3_6_step(String manPowerModelArrayList, Long businessplanId, Long entrepreneurId) {

        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_6_LIST_OF_MANPOWERS, manPowerModelArrayList);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_6_BUSINESSPLAN_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_6_ENTREPRENEUR_ID, entrepreneurId);
        return mSqLiteDatabase.insert(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_6_CREATE, null, values);
    }

    //STEP 3.6 UPDATE DATA
    public long updateEntrepreneurBP_3_6_step(String manPowerModelArrayList, Long businessplanId, Long entrepreneurId) {
        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_6_LIST_OF_MANPOWERS, manPowerModelArrayList);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_6_BUSINESSPLAN_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_6_ENTREPRENEUR_ID, entrepreneurId);
        String whereArgs[] = new String[1];
        whereArgs[0] = "" + entrepreneurId;
        return mSqLiteDatabase.update(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_6_CREATE, values, KEY_ENTREPRENEUR_BUSINESSPLAN_3_6_ENTREPRENEUR_ID + "= ?", whereArgs);

    }

    //STEP 3.6 GET ALL DATA
    public ArrayList<WorkExperienceDTOModel> getEntrepreneurBusinessplan_step_3_6_lListALL() {
        ArrayList<WorkExperienceDTOModel> mEntrepreneurBusinessplan_step_3_6_lList = new ArrayList<>();

        try {

            result = mSqLiteDatabase.query(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_6_CREATE, new String[]{}, null, null,
                    null, null, null);


            if (result.moveToFirst()) {
                do {
                    WorkExperienceDTOModel mWorkExperienceDTOModel = new WorkExperienceDTOModel();
                    String manpowersArrayList = result.getString(1);
                    Gson gson = new Gson();
                    TypeToken<ArrayList<ManPowerModel>> token = new TypeToken<ArrayList<ManPowerModel>>() {
                    };
                    ArrayList<ManPowerModel> manpowersModelArrayList = gson.fromJson(manpowersArrayList, token.getType());

                    mWorkExperienceDTOModel.setManpowerList(manpowersModelArrayList);
                    mWorkExperienceDTOModel.setBusinessPlanId(result.getLong(2));
                    mWorkExperienceDTOModel.setEntrepreneurId(result.getLong(3));

                    mEntrepreneurBusinessplan_step_3_6_lList.add(mWorkExperienceDTOModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_3_6_lList;
    }

    //STEP 3.6 SINGLE DATA
    public ArrayList<GetNewBusinessPlanDataModel.DataBean> getEntrepreneurBusinessplan_step_3_6_lList(Long entrepreneurId) {
        ArrayList<GetNewBusinessPlanDataModel.DataBean> mEntrepreneurBusinessplan_step_3_6_lList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENEUR_BUSINESSPLAN_3_6_CREATE
                            ,
                            new String[]{
                                    KEY_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_6_LIST_OF_MANPOWERS,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_6_BUSINESSPLAN_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_6_ENTREPRENEUR_ID},

                            KEY_ENTREPRENEUR_BUSINESSPLAN_3_6_ENTREPRENEUR_ID + "=" + entrepreneurId,
                            null, null, null, null, null
                    );

            if (result.moveToFirst()) {
                do {
                    GetNewBusinessPlanDataModel.DataBean mWorkExperienceDTOModel = new GetNewBusinessPlanDataModel.DataBean();
                    String manpowersArrayList = result.getString(1);
                    Gson gson = new Gson();
                    TypeToken<ArrayList<GetNewBusinessPlanDataModel.DataBean.ManpowersBean>> token = new TypeToken<ArrayList<GetNewBusinessPlanDataModel.DataBean.ManpowersBean>>() {
                    };
                    ArrayList<GetNewBusinessPlanDataModel.DataBean.ManpowersBean> manpowersModelArrayList = gson.fromJson(manpowersArrayList, token.getType());


                    mWorkExperienceDTOModel.setManpowers(manpowersModelArrayList);
                    mWorkExperienceDTOModel.setEntrepreneurId(result.getLong(3));

                    mEntrepreneurBusinessplan_step_3_6_lList.add(mWorkExperienceDTOModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_3_6_lList;
    }

    //STEP 3.7 INSERT,UPDATE AND GET  DATA
    public long insertEntrepreneurBP_3_7_step(String administrativeModelArrayList, Long businessplanId, Long entrepreneurId) {

        ContentValues values = new ContentValues();

        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_7_LIST_OF_ADMINISTRATIVES, administrativeModelArrayList);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_7_BUSINESSPLAN_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_7_ENTREPRENEUR_ID, entrepreneurId);

        return mSqLiteDatabase.insert(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_7_CREATE, null, values);
    }

    //STEP 3.7 UPDATE  DATA
    public long updateEntrepreneurBP_3_7_step(String administrativeModelArrayList, Long businessplanId, Long entrepreneurId) {
        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_7_LIST_OF_ADMINISTRATIVES, administrativeModelArrayList);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_7_BUSINESSPLAN_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_7_ENTREPRENEUR_ID, entrepreneurId);
        String whereArgs[] = new String[1];
        whereArgs[0] = "" + entrepreneurId;
        return mSqLiteDatabase.update(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_7_CREATE, values, KEY_ENTREPRENEUR_BUSINESSPLAN_3_7_ENTREPRENEUR_ID + "= ?", whereArgs);

    }

    //STEP 3.7 GET ALL  DATA
    public ArrayList<WorkExperienceDTOModel> getEntrepreneurBusinessplan_step_3_7_lListALL() {
        ArrayList<WorkExperienceDTOModel> mEntrepreneurBusinessplan_step_3_7_lList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_7_CREATE, new String[]{}, null, null,
                    null, null, null);


            if (result.moveToFirst()) {
                do {
                    WorkExperienceDTOModel mWorkExperienceDTOModel = new WorkExperienceDTOModel();
                    String administrativeArrayList = result.getString(1);
                    Gson gson = new Gson();
                    TypeToken<ArrayList<AdministrativeModel>> token = new TypeToken<ArrayList<AdministrativeModel>>() {
                    };
                    ArrayList<AdministrativeModel> administrativeModelArrayList = gson.fromJson(administrativeArrayList, token.getType());

                    mWorkExperienceDTOModel.setAdministrativeExpensesList(administrativeModelArrayList);
                    mWorkExperienceDTOModel.setBusinessPlanId(result.getLong(2));
                    mWorkExperienceDTOModel.setEntrepreneurId(result.getLong(3));

                    mEntrepreneurBusinessplan_step_3_7_lList.add(mWorkExperienceDTOModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_3_7_lList;
    }

    //STEP 3.7 GET SINGLE  DATA
    public ArrayList<GetNewBusinessPlanDataModel.DataBean> getEntrepreneurBusinessplan_step_3_7_lList(Long entrepreneurId) {
        ArrayList<GetNewBusinessPlanDataModel.DataBean> mEntrepreneurBusinessplan_step_3_7_lList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENEUR_BUSINESSPLAN_3_7_CREATE
                            ,
                            new String[]{
                                    KEY_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_7_LIST_OF_ADMINISTRATIVES,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_7_BUSINESSPLAN_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_7_ENTREPRENEUR_ID},

                            KEY_ENTREPRENEUR_BUSINESSPLAN_3_7_ENTREPRENEUR_ID + "=" + entrepreneurId,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {
                do {
                    GetNewBusinessPlanDataModel.DataBean mWorkExperienceDTOModel = new GetNewBusinessPlanDataModel.DataBean();
                    String administrativeArrayList = result.getString(1);
                    Gson gson = new Gson();
                    TypeToken<ArrayList<GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean>> token = new TypeToken<ArrayList<GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean>>() {
                    };
                    ArrayList<GetNewBusinessPlanDataModel.DataBean.AdministrativeExpensesBean> administrativeModelArrayList = gson.fromJson(administrativeArrayList, token.getType());

                    mWorkExperienceDTOModel.setAdministrativeExpenses(administrativeModelArrayList);
                    mWorkExperienceDTOModel.setEntrepreneurId(result.getLong(3));

                    mEntrepreneurBusinessplan_step_3_7_lList.add(mWorkExperienceDTOModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_3_7_lList;
    }

    //STEP 3.8 INSERT DATA
    public long insertEntrepreneurBP_3_8_step(String sellingDistributionExpensModelArrayList, Long businessplanId, Long entrepreneurId) {

        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_8_LIST_OF_SELLING, sellingDistributionExpensModelArrayList);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_8_BUSINESSPLAN_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_8_ENTREPRENEUR_ID, entrepreneurId);
        return mSqLiteDatabase.insert(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_8_CREATE, null, values);
    }

    //STEP 3.8 UPDATE DATA
    public long updateEntrepreneurBP_3_8_step(String sellingDistributionExpensModelArrayList, Long businessplanId, Long entrepreneurId) {
        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_8_LIST_OF_SELLING, sellingDistributionExpensModelArrayList);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_8_BUSINESSPLAN_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_8_ENTREPRENEUR_ID, entrepreneurId);
        String whereArgs[] = new String[1];
        whereArgs[0] = "" + entrepreneurId;
        return mSqLiteDatabase.update(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_8_CREATE, values, KEY_ENTREPRENEUR_BUSINESSPLAN_3_8_ENTREPRENEUR_ID + "= ?", whereArgs);
    }

    //STEP 3.8 GET ALL DATA
    public ArrayList<WorkExperienceDTOModel> getEntrepreneurBusinessplan_step_3_8_lListALL() {
        ArrayList<WorkExperienceDTOModel> mEntrepreneurBusinessplan_step_3_8_lList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_8_CREATE, new String[]{}, null, null,
                    null, null, null);


            if (result.moveToFirst()) {
                do {
                    WorkExperienceDTOModel mWorkExperienceDTOModel = new WorkExperienceDTOModel();
                    String sellingArrayList = result.getString(1);
                    Gson gson = new Gson();
                    TypeToken<ArrayList<SellingDistributionExpensModel>> token = new TypeToken<ArrayList<SellingDistributionExpensModel>>() {
                    };
                    ArrayList<SellingDistributionExpensModel> sellingModelArrayList = gson.fromJson(sellingArrayList, token.getType());

                    mWorkExperienceDTOModel.setSellingDistributionExpensesList(sellingModelArrayList);
                    mWorkExperienceDTOModel.setBusinessPlanId(result.getLong(2));
                    mWorkExperienceDTOModel.setEntrepreneurId(result.getLong(3));

                    mEntrepreneurBusinessplan_step_3_8_lList.add(mWorkExperienceDTOModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_3_8_lList;
    }

    //STEP 3.8 GET SINGLE DATA
    public ArrayList<GetNewBusinessPlanDataModel.DataBean> getEntrepreneurBusinessplan_step_3_8_lList(Long entrepreneurId) {
        ArrayList<GetNewBusinessPlanDataModel.DataBean> mEntrepreneurBusinessplan_step_3_8_lList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENEUR_BUSINESSPLAN_3_8_CREATE
                            ,
                            new String[]{
                                    KEY_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_8_LIST_OF_SELLING,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_8_BUSINESSPLAN_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_8_ENTREPRENEUR_ID},

                            KEY_ENTREPRENEUR_BUSINESSPLAN_3_8_ENTREPRENEUR_ID + "=" + entrepreneurId,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {
                do {
                    GetNewBusinessPlanDataModel.DataBean mWorkExperienceDTOModel = new GetNewBusinessPlanDataModel.DataBean();
                    String sellingArrayList = result.getString(1);
                    Gson gson = new Gson();
                    TypeToken<ArrayList<GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean>> token = new TypeToken<ArrayList<GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean>>() {
                    };
                    ArrayList<GetNewBusinessPlanDataModel.DataBean.SellingDistributionExpensesBean> sellingModelArrayList = gson.fromJson(sellingArrayList, token.getType());

                    mWorkExperienceDTOModel.setSellingDistributionExpenses(sellingModelArrayList);
                    mWorkExperienceDTOModel.setEntrepreneurId(result.getLong(3));

                    mEntrepreneurBusinessplan_step_3_8_lList.add(mWorkExperienceDTOModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_3_8_lList;
    }

    //STEP 3.9 INSERT DATA
    public long insertEntrepreneurBP_3_9_step(String depricationModelArrayList, Long businessplanId, Long entrepreneurId) {

        ContentValues values = new ContentValues();

        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_9_LIST_OF_WORKING_CAPITALS, depricationModelArrayList);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_9_BUSINESSPLAN_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_9_ENTREPRENEUR_ID, entrepreneurId);

        return mSqLiteDatabase.insert(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_9_CREATE, null, values);
    }

    //STEP 3.9 UPDATE DATA
    public long updateEntrepreneurBP_3_9_step(String depricationModelArrayList, Long businessplanId, Long entrepreneurId) {
        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_9_LIST_OF_WORKING_CAPITALS, depricationModelArrayList);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_9_BUSINESSPLAN_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_9_ENTREPRENEUR_ID, entrepreneurId);
        String whereArgs[] = new String[1];
        whereArgs[0] = "" + entrepreneurId;
        return mSqLiteDatabase.update(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_9_CREATE, values, KEY_ENTREPRENEUR_BUSINESSPLAN_3_9_ENTREPRENEUR_ID + "= ?", whereArgs);
    }

    //STEP 3.9 GET ALL DATA
    public ArrayList<WorkExperienceDTOModel> getEntrepreneurBusinessplan_step_3_9_lListALL() {
        ArrayList<WorkExperienceDTOModel> mEntrepreneurBusinessplan_step_3_9_lList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_9_CREATE, new String[]{}, null, null,
                    null, null, null);


            if (result.moveToFirst()) {
                do {
                    WorkExperienceDTOModel mWorkExperienceDTOModel = new WorkExperienceDTOModel();
                    String strWorkingCapitalsArrayList = result.getString(1);
                    Gson gson = new Gson();
                    TypeToken<ArrayList<WorkingCapitalModel>> token = new TypeToken<ArrayList<WorkingCapitalModel>>() {
                    };
                    ArrayList<WorkingCapitalModel> WorkingCapitalsArrayList = gson.fromJson(strWorkingCapitalsArrayList, token.getType());

                    mWorkExperienceDTOModel.setWorkingCapitalList(WorkingCapitalsArrayList);
                    mWorkExperienceDTOModel.setBusinessPlanId(result.getLong(2));
                    mWorkExperienceDTOModel.setEntrepreneurId(result.getLong(3));

                    mEntrepreneurBusinessplan_step_3_9_lList.add(mWorkExperienceDTOModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_3_9_lList;
    }

    //STEP 3.9 SINGLE DATA
    public ArrayList<GetNewBusinessPlanDataModel.DataBean> getEntrepreneurBusinessplan_step_3_9_lList(Long entrepreneurId) {
        ArrayList<GetNewBusinessPlanDataModel.DataBean> mEntrepreneurBusinessplan_step_3_9_lList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENEUR_BUSINESSPLAN_3_9_CREATE
                            ,
                            new String[]{
                                    KEY_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_9_LIST_OF_WORKING_CAPITALS,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_9_BUSINESSPLAN_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_9_ENTREPRENEUR_ID},

                            KEY_ENTREPRENEUR_BUSINESSPLAN_3_9_ENTREPRENEUR_ID + "=" + entrepreneurId,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {
                do {
                    GetNewBusinessPlanDataModel.DataBean mWorkExperienceDTOModel = new GetNewBusinessPlanDataModel.DataBean();
                    String strWorkingCapitalsArrayList = result.getString(1);
                    Gson gson = new Gson();
                    TypeToken<ArrayList<GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean>> token = new TypeToken<ArrayList<GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean>>() {
                    };
                    ArrayList<GetNewBusinessPlanDataModel.DataBean.WorkingCapitalsBean> WorkingCapitalsArrayList = gson.fromJson(strWorkingCapitalsArrayList, token.getType());

                    mWorkExperienceDTOModel.setWorkingCapitals(WorkingCapitalsArrayList);
                    mWorkExperienceDTOModel.setEntrepreneurId(result.getLong(3));

                    mEntrepreneurBusinessplan_step_3_9_lList.add(mWorkExperienceDTOModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_3_9_lList;
    }

    //----------(Insert and get Entrepreneur Businessplan step - 3.12 )------------//
    public long insertEntrepreneurBP_3_10_step(Double TotalProjectValue, Long businessplanId, Long entrepreneurId) {

        ContentValues values = new ContentValues();

        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_10_TOTAL_COST_ODF_PROJECT, TotalProjectValue);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_10_BUSINESSPLAN_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_3_10_ENTREPRENEUR_ID, entrepreneurId);

        return mSqLiteDatabase.insert(TABLE_ENTREPRENEUR_BUSINESSPLAN_3_10_CREATE, null, values);
    }

    public ArrayList<TotalProjectCostModel> getEntrepreneurBusinessplan_step_3_10_lList(Long entrepreneurId) {
        ArrayList<TotalProjectCostModel> mEntrepreneurBusinessplan_step_3_12_lList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENEUR_BUSINESSPLAN_3_10_CREATE
                            ,
                            new String[]{
                                    KEY_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_10_TOTAL_COST_ODF_PROJECT,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_10_BUSINESSPLAN_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_3_10_ENTREPRENEUR_ID},

                            KEY_ENTREPRENEUR_BUSINESSPLAN_3_10_ENTREPRENEUR_ID + "=" + entrepreneurId,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {
                do {
                    TotalProjectCostModel mTotalProjectCostModel = new TotalProjectCostModel();

                    mTotalProjectCostModel.setTotalProjectCost(result.getDouble(1));
                    mTotalProjectCostModel.setBusinessplanId(result.getLong(2));
                    mTotalProjectCostModel.setEntrepreneurId(result.getLong(3));

                    mEntrepreneurBusinessplan_step_3_12_lList.add(mTotalProjectCostModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_3_12_lList;
    }

    //STEP 4.0 INSERT DATA
    public long insertEntrepreneurBP_4_0_step(String meansOfFinanceModelArrayList, Long businessplanId, Long entrepreneurId) {
        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_4_0_LIST_OF_MEANS_OF_FINANCE, meansOfFinanceModelArrayList);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_4_0_BUSINESSPLAN_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_4_0_ENTREPRENEUR_ID, entrepreneurId);

        return mSqLiteDatabase.insert(TABLE_ENTREPRENEUR_BUSINESSPLAN_4_0_CREATE, null, values);
    }

    //STEP 4.0 UPDATE DATA
    public long updateEntrepreneurBP_4_0_step(String meansOfFinanceModelArrayList, Long businessplanId, Long entrepreneurId) {
        ContentValues values = new ContentValues();
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_4_0_LIST_OF_MEANS_OF_FINANCE, meansOfFinanceModelArrayList);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_4_0_BUSINESSPLAN_ID, businessplanId);
        values.put(KEY_ENTREPRENEUR_BUSINESSPLAN_4_0_ENTREPRENEUR_ID, entrepreneurId);
        String whereArgs[] = new String[1];
        whereArgs[0] = "" + entrepreneurId;
        return mSqLiteDatabase.update(TABLE_ENTREPRENEUR_BUSINESSPLAN_4_0_CREATE, values, KEY_ENTREPRENEUR_BUSINESSPLAN_4_0_ENTREPRENEUR_ID + "= ?", whereArgs);
    }

    //STEP 4.0 GET ALL DATA
    public ArrayList<WorkExperienceDTOModel> getEntrepreneurBusinessplan_step_4_0_lListALL() {
        ArrayList<WorkExperienceDTOModel> mEntrepreneurBusinessplan_step_4_0_lList = new ArrayList<>();

        try {

            result = mSqLiteDatabase.query(TABLE_ENTREPRENEUR_BUSINESSPLAN_4_0_CREATE, new String[]{}, null, null,
                    null, null, null);

            if (result.moveToFirst()) {
                do {
                    WorkExperienceDTOModel mWorkExperienceDTOModel = new WorkExperienceDTOModel();
                    String strMeansOfFinanceArrayList = result.getString(1);
                    Gson gson = new Gson();
                    TypeToken<ArrayList<MeansOfFinanceModel>> token = new TypeToken<ArrayList<MeansOfFinanceModel>>() {
                    };
                    ArrayList<MeansOfFinanceModel> MeansOfFinanceArrayList = gson.fromJson(strMeansOfFinanceArrayList, token.getType());

                    mWorkExperienceDTOModel.setFinanceMeansList(MeansOfFinanceArrayList);
                    mWorkExperienceDTOModel.setBusinessPlanId(result.getLong(2));
                    mWorkExperienceDTOModel.setEntrepreneurId(result.getLong(3));

                    mEntrepreneurBusinessplan_step_4_0_lList.add(mWorkExperienceDTOModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_4_0_lList;
    }

    //STEP 4.0 GET SINGLE DATA
    public ArrayList<GetNewBusinessPlanDataModel.DataBean> getEntrepreneurBusinessplan_step_4_0_lList(Long entrepreneurId) {
        ArrayList<GetNewBusinessPlanDataModel.DataBean> mEntrepreneurBusinessplan_step_4_0_lList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query
                    (TABLE_ENTREPRENEUR_BUSINESSPLAN_4_0_CREATE
                            ,
                            new String[]{
                                    KEY_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_4_0_LIST_OF_MEANS_OF_FINANCE,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_4_0_BUSINESSPLAN_ID,
                                    KEY_ENTREPRENEUR_BUSINESSPLAN_4_0_ENTREPRENEUR_ID},

                            KEY_ENTREPRENEUR_BUSINESSPLAN_4_0_ENTREPRENEUR_ID + "=" + entrepreneurId,
                            null, null, null, null, null
                    );


            if (result.moveToFirst()) {
                do {
                    GetNewBusinessPlanDataModel.DataBean mWorkExperienceDTOModel = new GetNewBusinessPlanDataModel.DataBean();
                    String strMeansOfFinanceArrayList = result.getString(1);
                    Gson gson = new Gson();
                    TypeToken<ArrayList<GetNewBusinessPlanDataModel.DataBean.FinanceMeansBean>> token = new TypeToken<ArrayList<GetNewBusinessPlanDataModel.DataBean.FinanceMeansBean>>() {
                    };
                    ArrayList<GetNewBusinessPlanDataModel.DataBean.FinanceMeansBean> MeansOfFinanceArrayList = gson.fromJson(strMeansOfFinanceArrayList, token.getType());

                    mWorkExperienceDTOModel.setFinanceMeans(MeansOfFinanceArrayList);
                    mWorkExperienceDTOModel.setEntrepreneurId(result.getLong(3));

                    mEntrepreneurBusinessplan_step_4_0_lList.add(mWorkExperienceDTOModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEntrepreneurBusinessplan_step_4_0_lList;
    }

    //----------(Insert and get Entrepreneur Businessplan step - 3.12 )------------//
    public long insertCampaignData(Long campaignID,
                                   String campaignName,
                                   Long campaignDate,
                                   String campaignAddress,
                                   String campaignMoreInfo,
                                   Long campaignMobileUserID,
                                   double latitude,
                                   double longitude) {

        ContentValues values = new ContentValues();
        values.put(KEY_CREATE_CAMPAIGN_ID, campaignID);
        values.put(KEY_CREATE_CAMPAIGN_NAME, campaignName);
        values.put(KEY_CREATE_CAMPAIGN_DATE, campaignDate);
        values.put(KEY_CREATE_CAMPAIGN_ADDRESS, campaignAddress);
        values.put(KEY_CREATE_CAMPAIGN_MORE_INFO, campaignMoreInfo);
        values.put(KEY_CREATE_CAMPAIGN_MOBILE_USER_ID, campaignMobileUserID);
        values.put(KEY_LATITUDE, latitude);
        values.put(KEY_LONGITUDE, longitude);

        return mSqLiteDatabase.insert(TABLE_CREATE_CAMPAIGN, null, values);
    }

    public ArrayList<CampaignDataModel> getCampaignDataByID(Long campaignID) {
        ArrayList<CampaignDataModel> mCampaignDataList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query
                    (TABLE_CREATE_CAMPAIGN,
                            new String[]{
                                    KEY_ID,
                                    KEY_CREATE_CAMPAIGN_ID,
                                    KEY_CREATE_CAMPAIGN_NAME,
                                    KEY_CREATE_CAMPAIGN_DATE,
                                    KEY_CREATE_CAMPAIGN_ADDRESS,
                                    KEY_CREATE_CAMPAIGN_MORE_INFO,
                                    KEY_CREATE_CAMPAIGN_MOBILE_USER_ID,
                                    KEY_LATITUDE,
                                    KEY_LONGITUDE
                                    },

                            KEY_CREATE_CAMPAIGN_ID + "=" + campaignID,
                            null, null, null, null, null
                    );

            if (result.moveToFirst()) {
                do {

                    CampaignDataModel mCampaignDataModel = new CampaignDataModel();
                    mCampaignDataModel.setCampaignID(result.getLong(1));
                    mCampaignDataModel.setCampaignName(result.getString(2));
                    mCampaignDataModel.setCampaignDate(result.getLong(3));
                    mCampaignDataModel.setCampaignAddress(result.getString(4));
                    mCampaignDataModel.setCampaignMoreInfo(result.getString(5));
                    mCampaignDataModel.setMobileUserID(result.getLong(6));
                    mCampaignDataModel.setLatitude(result.getDouble(7));
                    mCampaignDataModel.setLongitude(result.getDouble(8));
                    mCampaignDataList.add(mCampaignDataModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mCampaignDataList;
    }

    public ArrayList<CampaignDataModel> getCampaignData() {
        ArrayList<CampaignDataModel> mCampaignDataList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query(TABLE_CREATE_CAMPAIGN, new String[]{}, null, null,
                    null, null, null);
            if (result.moveToFirst()) {
                do {

                    CampaignDataModel mCampaignDataModel = new CampaignDataModel();
                    mCampaignDataModel.setCampaignID(result.getLong(1));
                    mCampaignDataModel.setCampaignName(result.getString(2));
                    mCampaignDataModel.setCampaignDate(result.getLong(3));
                    mCampaignDataModel.setCampaignAddress(result.getString(4));
                    mCampaignDataModel.setCampaignMoreInfo(result.getString(5));
                    mCampaignDataModel.setMobileUserID(result.getLong(6));
                    mCampaignDataModel.setLatitude(result.getDouble(7));
                    mCampaignDataModel.setLongitude(result.getDouble(8));
                    mCampaignDataList.add(mCampaignDataModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mCampaignDataList;
    }


    //INSERT EVENT MEMBERS
    public long insertEventMemberData(String memberName,
                                   Long memberBirhtdate,
                                   String memberPhoneNumber,
                                   Long memberID,
                                   Long mamberMobileUserID,
                                   double latitude,
                                   double longitude,
                                   Long memberCreatedDate,
                                      Long eventID) {

        ContentValues values = new ContentValues();
        values.put(KEY_CREATE_MEMBER_NAME, memberName);
        values.put(KEY_CREATE_MEMBER_BIRTH_DATE, memberBirhtdate);
        values.put(KEY_CREATE_MEMBER_PHONE_NUMBER, memberPhoneNumber);
        values.put(KEY_CREATE_MEMBER_ID, memberID);
        values.put(KEY_CREATE_MEMBER_MOBILE_USER_NAME_ID, mamberMobileUserID);
        values.put(KEY_LATITUDE, latitude);
        values.put(KEY_LONGITUDE, longitude);
        values.put(KEY_CREATE_MEMBER_CREAETED_DATE, memberCreatedDate);
        values.put(KEY_CREATE_MEMBER_EVENT_ID, eventID);
        return mSqLiteDatabase.insert(TABLE_CREATE_EVENT_MEMBER_TABLE, null, values);
    }
    public ArrayList<EventMemberModel> getMemberDataByMobileNumber(String mobileNumber) {
        ArrayList<EventMemberModel> mEventMemberList = new ArrayList<>();

        try {

            result = mSqLiteDatabase.query
                    (TABLE_CREATE_EVENT_MEMBER_TABLE,
                            new String[]{
                                    KEY_ID,
                                    KEY_CREATE_MEMBER_NAME,
                                    KEY_CREATE_MEMBER_BIRTH_DATE,
                                    KEY_CREATE_MEMBER_PHONE_NUMBER,
                                    KEY_CREATE_MEMBER_ID,
                                    KEY_CREATE_MEMBER_MOBILE_USER_NAME_ID,
                                    KEY_LATITUDE,
                                    KEY_LONGITUDE,
                                    KEY_CREATE_MEMBER_CREAETED_DATE,
                                    KEY_CREATE_MEMBER_EVENT_ID},

                            KEY_CREATE_MEMBER_PHONE_NUMBER + "=" + "'" + mobileNumber + "'" ,
                            null, null, null, null, null
                    );

            if (result.moveToFirst()) {
                do {

                    EventMemberModel mEventMemberModel = new EventMemberModel();
                    mEventMemberModel.setMemberName(result.getString(1));
                    mEventMemberModel.setMemberBirthdate(result.getLong(2));
                    mEventMemberModel.setMemberPhoneNumber(result.getString(3));
                    mEventMemberModel.setMemberID(result.getLong(4));
                    mEventMemberModel.setMobileUserID(result.getLong(5));
                    mEventMemberModel.setLatitude(result.getDouble(6));
                    mEventMemberModel.setLongitude(result.getDouble(7));
                    mEventMemberModel.setCreatedBy(result.getLong(8));
                    mEventMemberModel.setEventID(result.getLong(9));
                    mEventMemberList.add(mEventMemberModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEventMemberList;
    }

    public ArrayList<EventMemberModel> getMemberDataAll() {
        ArrayList<EventMemberModel> mEventMemberList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query(TABLE_CREATE_EVENT_MEMBER_TABLE, new String[]{}, null, null,
                    null, null, null);
            if (result.moveToFirst()) {
                do {

                    EventMemberModel mEventMemberModel = new EventMemberModel();
                    mEventMemberModel.setMemberName(result.getString(1));
                    mEventMemberModel.setMemberBirthdate(result.getLong(2));
                    mEventMemberModel.setMemberPhoneNumber(result.getString(3));
                    mEventMemberModel.setMemberID(result.getLong(4));
                    mEventMemberModel.setMobileUserID(result.getLong(5));
                    mEventMemberModel.setLatitude(result.getDouble(6));
                    mEventMemberModel.setLongitude(result.getDouble(7));
                    mEventMemberModel.setCreatedBy(result.getLong(8));
                    mEventMemberModel.setEventID(result.getLong(9));
                    mEventMemberList.add(mEventMemberModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEventMemberList;
    }

    public ArrayList<EventMemberModel> getMemberDataByEventID(Long eventID) {
        ArrayList<EventMemberModel> mEventMemberList = new ArrayList<>();

        try {

            result = mSqLiteDatabase.query
                    (TABLE_CREATE_EVENT_MEMBER_TABLE,
                            new String[]{
                                    KEY_ID,
                                    KEY_CREATE_MEMBER_NAME,
                                    KEY_CREATE_MEMBER_BIRTH_DATE,
                                    KEY_CREATE_MEMBER_PHONE_NUMBER,
                                    KEY_CREATE_MEMBER_ID,
                                    KEY_CREATE_MEMBER_MOBILE_USER_NAME_ID,
                                    KEY_LATITUDE,
                                    KEY_LONGITUDE,
                                    KEY_CREATE_MEMBER_CREAETED_DATE,
                                    KEY_CREATE_MEMBER_EVENT_ID},

                            KEY_CREATE_MEMBER_EVENT_ID + "=" + eventID,
                            null, null, null, null, null
                    );

            if (result.moveToFirst()) {
                do {

                    EventMemberModel mEventMemberModel = new EventMemberModel();
                    mEventMemberModel.setMemberName(result.getString(1));
                    mEventMemberModel.setMemberBirthdate(result.getLong(2));
                    mEventMemberModel.setMemberPhoneNumber(result.getString(3));
                    mEventMemberModel.setMemberID(result.getLong(4));
                    mEventMemberModel.setMobileUserID(result.getLong(5));
                    mEventMemberModel.setLatitude(result.getDouble(6));
                    mEventMemberModel.setLongitude(result.getDouble(7));
                    mEventMemberModel.setCreatedBy(result.getLong(8));
                    mEventMemberModel.setEventID(result.getLong(9));
                    mEventMemberList.add(mEventMemberModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEventMemberList;
    }
    //INSERT ENTERPRISE REGISTRATION DATA
    public long insertEnterpriseRegistrationData(String KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRENEUR_NAME,
                                                 String KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRISE_NAME,
                                                 Long KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRENEUR_ID,
                                                 Long KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRISE_ID,
                                                 Long KEY_CREATE_ENTERPRISE_REGISTRATION_BLOCK_ID,
                                                 Long KEY_CREATE_ENTERPRISE_REGISTRATION_VILLAGE_ID,
                                                 Long KEY_CREATE_ENTERPRISE_REGISTRATION_STARTING_DATE,
                                                 String KEY_CREATE_ENTERPRISE_REGISTRATION_IMAGE_URL,
                                                 Long KEY_CREATE_ENTERPRISE_REGISTRATION_CREATED_DATE,
                                                 double KEY_LATITUDE,
                                                 double KEY_LONGITUDE

                                       ) {

        ContentValues values = new ContentValues();
        values.put(this.KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRENEUR_NAME, KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRENEUR_NAME);
        values.put(this.KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRISE_NAME, KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRISE_NAME);
        values.put(this.KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRENEUR_ID, KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRENEUR_ID);
        values.put(this.KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRISE_ID, KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRISE_ID);
        values.put(this.KEY_CREATE_ENTERPRISE_REGISTRATION_BLOCK_ID, KEY_CREATE_ENTERPRISE_REGISTRATION_BLOCK_ID);
        values.put(this.KEY_CREATE_ENTERPRISE_REGISTRATION_VILLAGE_ID, KEY_CREATE_ENTERPRISE_REGISTRATION_VILLAGE_ID);
        values.put(this.KEY_CREATE_ENTERPRISE_REGISTRATION_STARTING_DATE, KEY_CREATE_ENTERPRISE_REGISTRATION_STARTING_DATE);
        values.put(this.KEY_CREATE_ENTERPRISE_REGISTRATION_IMAGE_URL, KEY_CREATE_ENTERPRISE_REGISTRATION_IMAGE_URL);
        values.put(this.KEY_CREATE_ENTERPRISE_REGISTRATION_CREATED_DATE, KEY_CREATE_ENTERPRISE_REGISTRATION_CREATED_DATE);
        values.put(this.KEY_LATITUDE, KEY_LATITUDE);
        values.put(this.KEY_LONGITUDE, KEY_LONGITUDE);
        return mSqLiteDatabase.insert(TABLE_CREATE_ENTERPRISE_REGISTRATION, null, values);
    }

    public ArrayList<EnterpriseRegistrationModel> getEnterpriseRegistrationData() {
        ArrayList<EnterpriseRegistrationModel> mEnterpriseRegistrationList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query(TABLE_CREATE_ENTERPRISE_REGISTRATION, new String[]{}, null, null,
                    null, null, null);
            if (result.moveToFirst()) {
                do {

                    EnterpriseRegistrationModel mEnterpriseRegistrationModel = new EnterpriseRegistrationModel();
                    mEnterpriseRegistrationModel.setEnterpreneurName(result.getString(1));
                    mEnterpriseRegistrationModel.setEnterpriseName(result.getString(2));
                    mEnterpriseRegistrationModel.setEnterpreneurID(result.getLong(3));
                    mEnterpriseRegistrationModel.setEnterpriseID(result.getLong(4));
                    mEnterpriseRegistrationModel.setBlockID(result.getLong(5));
                    mEnterpriseRegistrationModel.setVillageID(result.getLong(6));
                    mEnterpriseRegistrationModel.setEnterpriseStartingDate(result.getLong(7));
                    mEnterpriseRegistrationModel.setUploadEnterpriseImage(result.getString(8));
                    mEnterpriseRegistrationModel.setCreatedDate(result.getLong(9));
                    mEnterpriseRegistrationModel.setLatitude(result.getDouble(10));
                    mEnterpriseRegistrationModel.setLongitude(result.getDouble(11));


                    mEnterpriseRegistrationList.add(mEnterpriseRegistrationModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEnterpriseRegistrationList;
    }
    public ArrayList<EnterpriseRegistrationModel> getEnterpriseRegistrationDataByVillageID(Long villageID) {
        ArrayList<EnterpriseRegistrationModel> mEnterpriseRegistrationList = new ArrayList<>();

        try {

            result = mSqLiteDatabase.query
                    (TABLE_CREATE_ENTERPRISE_REGISTRATION,
                            new String[]{
                                    KEY_ID,
                                    KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRENEUR_NAME,
                                    KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRISE_NAME,
                                    KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRENEUR_ID,
                                    KEY_CREATE_ENTERPRISE_REGISTRATION_ENTERPRISE_ID,
                                    KEY_CREATE_ENTERPRISE_REGISTRATION_BLOCK_ID,
                                    KEY_CREATE_ENTERPRISE_REGISTRATION_VILLAGE_ID,
                                    KEY_CREATE_ENTERPRISE_REGISTRATION_STARTING_DATE,
                                    KEY_CREATE_ENTERPRISE_REGISTRATION_IMAGE_URL,
                                    KEY_CREATE_ENTERPRISE_REGISTRATION_CREATED_DATE,
                                    KEY_LATITUDE,
                                    KEY_LONGITUDE},

                            KEY_CREATE_ENTERPRISE_REGISTRATION_VILLAGE_ID + "=" + villageID,
                            null, null, null, null, null
                    );



            if (result.moveToFirst()) {
                do {

                    EnterpriseRegistrationModel mEnterpriseRegistrationModel = new EnterpriseRegistrationModel();
                    mEnterpriseRegistrationModel.setEnterpreneurName(result.getString(1));
                    mEnterpriseRegistrationModel.setEnterpriseName(result.getString(2));
                    mEnterpriseRegistrationModel.setEnterpreneurID(result.getLong(3));
                    mEnterpriseRegistrationModel.setEnterpriseID(result.getLong(4));
                    mEnterpriseRegistrationModel.setBlockID(result.getLong(5));
                    mEnterpriseRegistrationModel.setVillageID(result.getLong(6));
                    mEnterpriseRegistrationModel.setEnterpriseStartingDate(result.getLong(7));
                    mEnterpriseRegistrationModel.setUploadEnterpriseImage(result.getString(8));
                    mEnterpriseRegistrationModel.setCreatedDate(result.getLong(9));
                    mEnterpriseRegistrationModel.setLatitude(result.getDouble(10));
                    mEnterpriseRegistrationModel.setLongitude(result.getDouble(11));

                    mEnterpriseRegistrationList.add(mEnterpriseRegistrationModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEnterpriseRegistrationList;
    }


    //INSERT ENTERPRISE TRACKING DATA
    public long insertEnterpriseTrackingData(String KEY_CREATE_ENTERPRISE_TRACKING_ENTERPRISE_NAME,
                                             Long KEY_CREATE_ENTERPRISE_TRACKING_ENTERPRISE_ID,
                                             Long KEY_CREATE_ENTERPRISE_TRACKING_ENTERPRENEURE_ID,
                                             Long KEY_CREATE_ENTERPRISE_TRACKING_MOBILE_USER_ID,
                                             String KEY_CREATE_ENTERPRISE_TRACKING_STATUS,
                                             double KEY_CREATE_ENTERPRISE_TRACKING_TURNOVER,
                                             double KEY_CREATE_ENTERPRISE_TRACKING_PROFITES,
                                             int KEY_CREATE_ENTERPRISE_TRACKING_PEAPOLE_EMPLOYED,
                                             double KEY_CREATE_ENTERPRISE_TRACKING_CAPITAL_DEPLOY,
                                             double KEY_CREATE_ENTERPRISE_TRACKING_RETURN_ON_INVESTMENT,
                                             double KEY_CREATE_ENTERPRISE_TRACKING_PROFITE_AS_PERCENTAGE,
                                             Long KEY_CREATE_ENTERPRISE_TRACKING_CURRENT_TIME,
                                             double KEY_LATITUDE,
                                             double KEY_LONGITUDE) {

        ContentValues values = new ContentValues();
        values.put(this.KEY_CREATE_ENTERPRISE_TRACKING_ENTERPRISE_NAME, KEY_CREATE_ENTERPRISE_TRACKING_ENTERPRISE_NAME);
        values.put(this.KEY_CREATE_ENTERPRISE_TRACKING_ENTERPRISE_ID, KEY_CREATE_ENTERPRISE_TRACKING_ENTERPRISE_ID);
        values.put(this.KEY_CREATE_ENTERPRISE_TRACKING_ENTERPRENEURE_ID, KEY_CREATE_ENTERPRISE_TRACKING_ENTERPRENEURE_ID);
        values.put(this.KEY_CREATE_ENTERPRISE_TRACKING_MOBILE_USER_ID, KEY_CREATE_ENTERPRISE_TRACKING_MOBILE_USER_ID);
        values.put(this.KEY_CREATE_ENTERPRISE_TRACKING_STATUS, KEY_CREATE_ENTERPRISE_TRACKING_STATUS);
        values.put(this.KEY_CREATE_ENTERPRISE_TRACKING_TURNOVER, KEY_CREATE_ENTERPRISE_TRACKING_TURNOVER);
        values.put(this.KEY_CREATE_ENTERPRISE_TRACKING_PROFITES, KEY_CREATE_ENTERPRISE_TRACKING_PROFITES);
        values.put(this.KEY_CREATE_ENTERPRISE_TRACKING_PEAPOLE_EMPLOYED, KEY_CREATE_ENTERPRISE_TRACKING_PEAPOLE_EMPLOYED);
        values.put(this.KEY_CREATE_ENTERPRISE_TRACKING_CAPITAL_DEPLOY, KEY_CREATE_ENTERPRISE_TRACKING_CAPITAL_DEPLOY);
        values.put(this.KEY_CREATE_ENTERPRISE_TRACKING_RETURN_ON_INVESTMENT, KEY_CREATE_ENTERPRISE_TRACKING_RETURN_ON_INVESTMENT);
        values.put(this.KEY_CREATE_ENTERPRISE_TRACKING_PROFITE_AS_PERCENTAGE, KEY_CREATE_ENTERPRISE_TRACKING_PROFITE_AS_PERCENTAGE);
        values.put(this.KEY_CREATE_ENTERPRISE_TRACKING_CURRENT_TIME, KEY_CREATE_ENTERPRISE_TRACKING_CURRENT_TIME);
        values.put(this.KEY_LATITUDE, KEY_LATITUDE);
        values.put(this.KEY_LONGITUDE, KEY_LONGITUDE);

        return mSqLiteDatabase.insert(TABLE_CREATE_ENTERPRISE_TRACKING, null, values);
    }

    public ArrayList<EnterpriseTrackingData> getEnterpriseTrackingData() {
        ArrayList<EnterpriseTrackingData> mEnterpriseTrackingList = new ArrayList<>();

        try {
            result = mSqLiteDatabase.query(TABLE_CREATE_ENTERPRISE_TRACKING, new String[]{}, null, null,
                    null, null, null);
            if (result.moveToFirst()) {
                do {

                    EnterpriseTrackingData mEnterpriseTrackingDataModel = new EnterpriseTrackingData();
                    mEnterpriseTrackingDataModel.setEnterpriseName(result.getString(1));
                    mEnterpriseTrackingDataModel.setEnterpriseID(result.getLong(2));
                    mEnterpriseTrackingDataModel.setEnterpreneurID(result.getLong(3));
                    mEnterpriseTrackingDataModel.setMobileUserID(result.getLong(4));
                    mEnterpriseTrackingDataModel.setStatus(result.getString(5));
                    mEnterpriseTrackingDataModel.setTurnOver(result.getDouble(6));
                    mEnterpriseTrackingDataModel.setProfite(result.getDouble(7));
                    mEnterpriseTrackingDataModel.setPeopleEmployed(result.getInt(8));
                    mEnterpriseTrackingDataModel.setCapitalDeployed(result.getDouble(9));
                    mEnterpriseTrackingDataModel.setReturnOnInvestment(result.getDouble(10));
                    mEnterpriseTrackingDataModel.setProfiteAsPercentage(result.getDouble(11));
                    mEnterpriseTrackingDataModel.setCurrentTime(result.getLong(12));
                    mEnterpriseTrackingDataModel.setLatitude(result.getDouble(13));
                    mEnterpriseTrackingDataModel.setLongitude(result.getDouble(14));
                    mEnterpriseTrackingList.add(mEnterpriseTrackingDataModel);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return mEnterpriseTrackingList;
    }

    //CLEAR ALL ENTERPRENEUR DETAILS
    public static void clearAllEntrepreneurTables() {
        mSqLiteDatabase.delete(TABLE_ENTREPRENUR_EXPENDITURES_LIST, null, null);
    }


    //Clear clearNewGrowthPlanPurposeListData from database
    public static void clearNewGrowthPlanPurposeListData() {
        mSqLiteDatabase.delete(TABLE_NEW_GROWTH_PURPOSE_LIST, null, null);

    }

    //CLEAR TRAINING DETAILS
    public static void clearSvepTrainingTable() {
        mSqLiteDatabase.delete(TABLE_ENTREPRENEUR_TRAINING, null, null);
    }

    //CLEAR EXPENDITURE DETAILS
    public static void clearEntrepreneurExpenditureRegistrationTable() {
        mSqLiteDatabase.delete(TABLE_ENTREPRENEUR_EXPENDITURE, null, null);
    }


    //Clear all basic details table
    public static void clearAllSQLiteData() {

        mSqLiteDatabase.delete(TABLE_STATES, null, null);
        mSqLiteDatabase.delete(TABLE_DISTRICT, null, null);
        mSqLiteDatabase.delete(TABLE_BLOCK, null, null);
        mSqLiteDatabase.delete(TABLE_VILLAGE, null, null);
        mSqLiteDatabase.delete(TABLE_GRAMPANCHAYAT, null, null);
        mSqLiteDatabase.delete(TABLE_CAST_LIST, null, null);
        mSqLiteDatabase.delete(TABLE_RELIGION_LIST, null, null);
        // mSqLiteDatabase.delete(TABLE_ENTREPRENUR_EDUCATION_QUALIFICATION_LIST, null, null);
        // mSqLiteDatabase.delete(TABLE_ENTREPRENUR_SPECIAL_TRAINING_LIST, null, null);
        // mSqLiteDatabase.delete(TABLE_ENTREPRENUR_WORK_EXPERIENCE_LIST, null, null);

    }


}