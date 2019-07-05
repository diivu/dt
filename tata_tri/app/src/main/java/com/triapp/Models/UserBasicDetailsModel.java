package com.triapp.Models;

import java.util.List;

/**
 * Created by Developer on 03-08-2017.
 */

public class UserBasicDetailsModel {
    /**
     * code : 1
     * data : {"listLoanType":[{"id":5,"name":"Cooperative Society"},{"id":4,"name":"Money Lenders"},{"id":3,"name":"Banks"}],"listBlock":[{"blockId":3121002,"blockCode":"3121002","blockName":"FIROZABAD","stateCode":"31","districtCode":"3121"}],"listItemType":[{"id":1,"name":"Food"},{"id":2,"name":"Education"},{"id":3,"name":"Health"},{"id":4,"name":"Clothes"},{"id":5,"name":"Festivals"},{"id":6,"name":"Transportation"}],"listEnterpriseCensusType":[{"id":1,"type":"Fixed"},{"id":2,"type":"Mobile"},{"id":3,"type":"Haat"}],"listHotspotArea":[{"id":1,"name":"Colony Area"},{"id":2,"name":"Market Area"},{"id":3,"name":"Road Market"},{"id":4,"name":"Weekly Haat"}],"listVillage":[{"villageId":3121002013003,"villageCode":"3121002013003","villageName":"NAGLAPACHIYA","grampanchayatCode":"3121002013","stateCode":"31","districtCode":"3121","blockCode":"3121002"},{"villageId":3121002014001,"villageCode":"3121002014001","villageName":"SALEMPURNAGLAKHAR","grampanchayatCode":"3121002014","stateCode":"31","districtCode":"3121","blockCode":"3121002"},{"villageId":3121002016001,"villageCode":"3121002016001","villageName":"ALAMPURZARKHI","grampanchayatCode":"3121002016","stateCode":"31","districtCode":"3121","blockCode":"3121002"}],"listSHGRelationship":[{"id":1,"relationshipName":"Self"},{"id":2,"relationshipName":"Husband"},{"id":3,"relationshipName":"Unmarried Son"},{"id":4,"relationshipName":"Unmarried Daughter"},{"id":5,"relationshipName":"Unmarried Brother"},{"id":9,"relationshipName":"Unmarried Sister"},{"id":6,"relationshipName":"Father"},{"id":7,"relationshipName":"In-laws"},{"id":8,"relationshipName":"Others"}],"listTraningAttended":["SVEP","Non SVEP"],"listSalesType":[{"id":1,"salesType":"Retail"},{"id":2,"salesType":"Wholesale"},{"id":3,"salesType":"Both"}],"listRoad":[{"id":1,"roadType":"Major Road"},{"id":2,"roadType":"Village Road"},{"id":3,"roadType":"Lane"},{"id":4,"roadType":"National Highway"},{"id":5,"roadType":"State Highway"}],"listSHG":[{"id":null,"shgName":null,"shgCode":"10788","shgType":"N","entityCode":"3121002014001","groupName":"JAI MATA DI","meetingFrequency":"M","shg_category":"NOtherSHG","shg_active":"Y"},{"id":null,"shgName":null,"shgCode":"10783","shgType":"N","entityCode":"3121002014001","groupName":"SAMAJWADI","meetingFrequency":"M","shg_category":"NOtherSHG","shg_active":"Y"},{"id":null,"shgName":null,"shgCode":"10793","shgType":"N","entityCode":"3121002014001","groupName":"BALA JI","meetingFrequency":"","shg_category":"NOtherSHG","shg_active":"Y"},{"id":null,"shgName":null,"shgCode":"171840","shgType":"N","entityCode":"3121002016001","groupName":"Maa Kaila Devi","meetingFrequency":"W","shg_category":"PSCSHG","shg_active":"Y"},{"id":null,"shgName":null,"shgCode":"171407","shgType":"N","entityCode":"3121002016001","groupName":"Shri Radha Rani","meetingFrequency":"W","shg_category":"PSCSHG","shg_active":"Y"}],"listSocialGroup":[{"id":1,"name":"SC"},{"id":2,"name":"ST"},{"id":3,"name":"OBC"},{"id":4,"name":"Minority"},{"id":5,"name":"General"}],"listHotspotPoint":[{"id":1,"name":"Auto Stand"},{"id":2,"name":"Bank"},{"id":3,"name":"Chowk"},{"id":4,"name":"Cinema Hall"},{"id":5,"name":"Education Institute"},{"id":6,"name":"Factory"},{"id":7,"name":"Government Office"},{"id":8,"name":"Hospital"},{"id":9,"name":"Main Centre"},{"id":10,"name":"Railway Station"},{"id":11,"name":"Religious Spot"},{"id":12,"name":"Tourist Spot"}],"listState":[{"stateId":31,"stateCode":"31","stateName":"UTTAR PRADESH","stateShortName":"UP"}],"listHotspotSize":[{"id":1,"name":"Large"},{"id":2,"name":"Medium"},{"id":3,"name":"Small"}],"listReligion":[{"id":1,"name":"Hinduism"},{"id":4,"name":"Sikhism"},{"id":5,"name":"Buddhism "},{"id":6,"name":"Jainism"},{"id":3,"name":"Christianity"},{"id":2,"name":"Islam"},{"id":7,"name":"Parsi"},{"id":8,"name":"Jew"},{"id":9,"name":"Other"}],"listEnterpriseCensusMarket":[{"id":1,"market":"Small Market"},{"id":2,"market":"Stand alone"},{"id":3,"market":"Large Market"}],"listFieldOfficer":[{"id":1,"name":"field officer 1"},{"id":2,"name":"field officer 2"}],"listDistrict":[{"districtId":3121,"districtCode":"3121","districtName":"FIROZABAD","stateCode":"31","districtShortName":"FI"}],"listCaste":[{"id":1,"name":"SC"},{"id":2,"name":"ST"},{"id":3,"name":"OBC"},{"id":4,"name":"Minority"},{"id":5,"name":"General"}],"listGramPanchayat":[{"grampanchayatId":3121002014,"grampanchayatCode":"3121002014","grampanchayatName":"3121002014","stateCode":"31","districtCode":"3121","blockCode":"3121002"},{"grampanchayatId":3121002016,"grampanchayatCode":"3121002016","grampanchayatName":"3121002016","stateCode":"31","districtCode":"3121","blockCode":"3121002"},{"grampanchayatId":3121002013,"grampanchayatCode":"3121002013","grampanchayatName":"3121002013","stateCode":"31","districtCode":"3121","blockCode":"3121002"}],"listEnterpriseCensusSize":[{"id":1,"size":"Small"},{"id":2,"size":"Medium"},{"id":3,"size":"Large"}]}
     * message : Success
     * description : null
     */

    private int code;
    private DataBean data;
    private String message;
    private Object description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public static class DataBean {
        private List<ListLoanTypeBean> listLoanType;
        private List<ListBlockBean> listBlock;
        private List<ListItemTypeBean> listItemType;
        private List<ListEnterpriseCensusTypeBean> listEnterpriseCensusType;
        private List<ListHotspotAreaBean> listHotspotArea;
        private List<ListVillageBean> listVillage;
        private List<ListSHGRelationshipBean> listSHGRelationship;
        private List<String> listTraningAttended;
        private List<ListSalesTypeBean> listSalesType;
        private List<ListActivityBean> listActivity;
        private List<ListRoadBean> listRoad;
        private List<ListSHGBean> listSHG;
        private List<ListSocialGroupBean> listSocialGroup;
        private List<ListHotspotPointBean> listHotspotPoint;
        private List<ListRejectionReasonBean> listRejectionReason;
        private List<ListStateBean> listState;
        private List<ListHotspotSizeBean> listHotspotSize;
        private List<ListReligionBean> listReligion;
        private List<ListEnterpriseCensusMarketBean> listEnterpriseCensusMarket;
        private List<ListFieldOfficerBean> listFieldOfficer;
        private List<ListDistrictBean> listDistrict;
        private List<ListCasteBean> listCaste;
        private List<ListGramPanchayatBean> listGramPanchayat;
        private List<ListEnterpriseCensusSizeBean> listEnterpriseCensusSize;
        private List<DayBookExpenses> listDaybookExpenses;
        private List<DayBookCategoryItems> listBookingCategory;
        private List<DayBookCashInflow> listCashInflow;
        private List<DayBookCashOutflow> listCashOutflow;

        public List<ListLoanTypeBean> getListLoanType() {
            return listLoanType;
        }

        public void setListLoanType(List<ListLoanTypeBean> listLoanType) {
            this.listLoanType = listLoanType;
        }

        public List<ListBlockBean> getListBlock() {
            return listBlock;
        }

        public void setListBlock(List<ListBlockBean> listBlock) {
            this.listBlock = listBlock;
        }

        public List<ListItemTypeBean> getListItemType() {
            return listItemType;
        }

        public void setListItemType(List<ListItemTypeBean> listItemType) {
            this.listItemType = listItemType;
        }

        public List<ListEnterpriseCensusTypeBean> getListEnterpriseCensusType() {
            return listEnterpriseCensusType;
        }

        public void setListEnterpriseCensusType(List<ListEnterpriseCensusTypeBean> listEnterpriseCensusType) {
            this.listEnterpriseCensusType = listEnterpriseCensusType;
        }

        public List<ListHotspotAreaBean> getListHotspotArea() {
            return listHotspotArea;
        }

        public void setListHotspotArea(List<ListHotspotAreaBean> listHotspotArea) {
            this.listHotspotArea = listHotspotArea;
        }

        public List<ListVillageBean> getListVillage() {
            return listVillage;
        }

        public void setListVillage(List<ListVillageBean> listVillage) {
            this.listVillage = listVillage;
        }

        public List<ListSHGRelationshipBean> getListSHGRelationship() {
            return listSHGRelationship;
        }

        public void setListSHGRelationship(List<ListSHGRelationshipBean> listSHGRelationship) {
            this.listSHGRelationship = listSHGRelationship;
        }

        public List<String> getListTraningAttended() {
            return listTraningAttended;
        }

        public void setListTraningAttended(List<String> listTraningAttended) {
            this.listTraningAttended = listTraningAttended;
        }

        public List<ListSalesTypeBean> getListSalesType() {
            return listSalesType;
        }

        public void setListSalesType(List<ListSalesTypeBean> listSalesType) {
            this.listSalesType = listSalesType;
        }

        public List<ListRoadBean> getListRoad() {
            return listRoad;
        }

        public void setListRoad(List<ListRoadBean> listRoad) {
            this.listRoad = listRoad;
        }

        public List<ListSHGBean> getListSHG() {
            return listSHG;
        }

        public void setListSHG(List<ListSHGBean> listSHG) {
            this.listSHG = listSHG;
        }

        public List<ListSocialGroupBean> getListSocialGroup() {
            return listSocialGroup;
        }

        public void setListSocialGroup(List<ListSocialGroupBean> listSocialGroup) {
            this.listSocialGroup = listSocialGroup;
        }

        public List<ListHotspotPointBean> getListHotspotPoint() {
            return listHotspotPoint;
        }

        public void setListHotspotPoint(List<ListHotspotPointBean> listHotspotPoint) {
            this.listHotspotPoint = listHotspotPoint;
        }

        public List<ListStateBean> getListState() {
            return listState;
        }

        public void setListState(List<ListStateBean> listState) {
            this.listState = listState;
        }

        public List<ListHotspotSizeBean> getListHotspotSize() {
            return listHotspotSize;
        }

        public void setListHotspotSize(List<ListHotspotSizeBean> listHotspotSize) {
            this.listHotspotSize = listHotspotSize;
        }

        public List<ListReligionBean> getListReligion() {
            return listReligion;
        }

        public void setListReligion(List<ListReligionBean> listReligion) {
            this.listReligion = listReligion;
        }

        public List<ListEnterpriseCensusMarketBean> getListEnterpriseCensusMarket() {
            return listEnterpriseCensusMarket;
        }

        public void setListEnterpriseCensusMarket(List<ListEnterpriseCensusMarketBean> listEnterpriseCensusMarket) {
            this.listEnterpriseCensusMarket = listEnterpriseCensusMarket;
        }

        public List<ListFieldOfficerBean> getListFieldOfficer() {
            return listFieldOfficer;
        }

        public void setListFieldOfficer(List<ListFieldOfficerBean> listFieldOfficer) {
            this.listFieldOfficer = listFieldOfficer;
        }

        public List<ListDistrictBean> getListDistrict() {
            return listDistrict;
        }

        public void setListDistrict(List<ListDistrictBean> listDistrict) {
            this.listDistrict = listDistrict;
        }

        public List<ListCasteBean> getListCaste() {
            return listCaste;
        }

        public void setListCaste(List<ListCasteBean> listCaste) {
            this.listCaste = listCaste;
        }

        public List<ListGramPanchayatBean> getListGramPanchayat() {
            return listGramPanchayat;
        }

        public void setListGramPanchayat(List<ListGramPanchayatBean> listGramPanchayat) {
            this.listGramPanchayat = listGramPanchayat;
        }

        public List<ListEnterpriseCensusSizeBean> getListEnterpriseCensusSize() {
            return listEnterpriseCensusSize;
        }

        public void setListEnterpriseCensusSize(List<ListEnterpriseCensusSizeBean> listEnterpriseCensusSize) {
            this.listEnterpriseCensusSize = listEnterpriseCensusSize;
        }

        public List<DayBookExpenses> getListDaybookExpenses() {
            return listDaybookExpenses;
        }

        public void setListDaybookExpenses(List<DayBookExpenses> listDaybookExpenses) {
            this.listDaybookExpenses = listDaybookExpenses;
        }

        public List<DayBookCategoryItems> getListBookingCategory() {
            return listBookingCategory;
        }

        public void setListBookingCategory(List<DayBookCategoryItems> listBookingCategory) {
            this.listBookingCategory = listBookingCategory;
        }

        public List<DayBookCashInflow> getListCashInflow() {
            return listCashInflow;
        }

        public void setListCashInflow(List<DayBookCashInflow> listCashInflow) {
            this.listCashInflow = listCashInflow;
        }

        public List<DayBookCashOutflow> getListCashOutflow() {
            return listCashOutflow;
        }

        public void setListCashOutflow(List<DayBookCashOutflow> listCashOutflow) {
            this.listCashOutflow = listCashOutflow;
        }

        public List<ListActivityBean> getListActivity() {
            return listActivity;
        }

        public void setListActivity(List<ListActivityBean> listActivity) {
            this.listActivity = listActivity;
        }

        public List<ListRejectionReasonBean> getListRejectionReason() {
            return listRejectionReason;
        }

        public void setListRejectionReason(List<ListRejectionReasonBean> listRejectionReason) {
            this.listRejectionReason = listRejectionReason;
        }


        public static class ListLoanTypeBean {
            /**
             * id : 5
             * name : Cooperative Society
             */

            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class ListBlockBean {
            /**
             * blockId : 3121002
             * blockCode : 3121002
             * blockName : FIROZABAD
             * stateCode : 31
             * districtCode : 3121
             */

            private Long blockId;
            private String blockCode;
            private String blockName;
            private String stateCode;
            private String districtCode;

            public Long getBlockId() {
                return blockId;
            }

            public void setBlockId(Long blockId) {
                this.blockId = blockId;
            }

            public String getBlockCode() {
                return blockCode;
            }

            public void setBlockCode(String blockCode) {
                this.blockCode = blockCode;
            }

            public String getBlockName() {
                return blockName;
            }

            public void setBlockName(String blockName) {
                this.blockName = blockName;
            }

            public String getStateCode() {
                return stateCode;
            }

            public void setStateCode(String stateCode) {
                this.stateCode = stateCode;
            }

            public String getDistrictCode() {
                return districtCode;
            }

            public void setDistrictCode(String districtCode) {
                this.districtCode = districtCode;
            }
        }

        public static class ListItemTypeBean {
            /**
             * id : 1
             * name : Food
             */

            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class ListEnterpriseCensusTypeBean {
            /**
             * id : 1
             * type : Fixed
             */

            private int id;
            private String type;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class ListHotspotAreaBean {
            /**
             * id : 1
             * name : Colony Area
             */

            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class ListVillageBean {
            /**
             * villageId : 3121002013003
             * villageCode : 3121002013003
             * villageName : NAGLAPACHIYA
             * grampanchayatCode : 3121002013
             * stateCode : 31
             * districtCode : 3121
             * blockCode : 3121002
             */

            private long villageId;
            private String villageCode;
            private String villageName;
            private String grampanchayatCode;
            private String stateCode;
            private String districtCode;
            private String blockCode;
            private boolean stratifiedSurveyDone;
            private boolean enterpriseCensusDone;
            private boolean hhConsumptionDone;
            private boolean villegeSelectForHHSurvey;
            private boolean censusDoneForBlock;



            public long getVillageId() {
                return villageId;
            }

            public void setVillageId(long villageId) {
                this.villageId = villageId;
            }

            public String getVillageCode() {
                return villageCode;
            }

            public void setVillageCode(String villageCode) {
                this.villageCode = villageCode;
            }

            public String getVillageName() {
                return villageName;
            }

            public void setVillageName(String villageName) {
                this.villageName = villageName;
            }

            public String getGrampanchayatCode() {
                return grampanchayatCode;
            }

            public void setGrampanchayatCode(String grampanchayatCode) {
                this.grampanchayatCode = grampanchayatCode;
            }

            public String getStateCode() {
                return stateCode;
            }

            public void setStateCode(String stateCode) {
                this.stateCode = stateCode;
            }

            public String getDistrictCode() {
                return districtCode;
            }

            public void setDistrictCode(String districtCode) {
                this.districtCode = districtCode;
            }

            public String getBlockCode() {
                return blockCode;
            }

            public void setBlockCode(String blockCode) {
                this.blockCode = blockCode;
            }

            public boolean isStratifiedSurveyDone() {
                return stratifiedSurveyDone;
            }

            public void setStratifiedSurveyDone(boolean stratifiedSurveyDone) {
                this.stratifiedSurveyDone = stratifiedSurveyDone;
            }

            public boolean isEnterpriseCensusDone() {
                return enterpriseCensusDone;
            }

            public void setEnterpriseCensusDone(boolean enterpriseCensusDone) {
                this.enterpriseCensusDone = enterpriseCensusDone;
            }


            public boolean isHhConsumptionDone() {
                return hhConsumptionDone;
            }

            public void setHhConsumptionDone(boolean hhConsumptionDone) {
                this.hhConsumptionDone = hhConsumptionDone;
            }

            public boolean isVillegeSelectForHHSurvey() {
                return villegeSelectForHHSurvey;
            }

            public void setVillegeSelectForHHSurvey(boolean villegeSelectForHHSurvey) {
                this.villegeSelectForHHSurvey = villegeSelectForHHSurvey;
            }

            public boolean isCensusDoneForBlock() {
                return censusDoneForBlock;
            }

            public void setCensusDoneForBlock(boolean censusDoneForBlock) {
                censusDoneForBlock = censusDoneForBlock;
            }
        }

        public static class ListSHGRelationshipBean {
            /**
             * id : 1
             * relationshipName : Self
             */

            private int id;
            private String relationshipName;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getRelationshipName() {
                return relationshipName;
            }

            public void setRelationshipName(String relationshipName) {
                this.relationshipName = relationshipName;
            }
        }

        public static class ListSalesTypeBean {
            /**
             * id : 1
             * salesType : Retail
             */

            private int id;
            private String salesType;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSalesType() {
                return salesType;
            }

            public void setSalesType(String salesType) {
                this.salesType = salesType;
            }
        }

        public static class ListActivityBean {
            private int id;
            private String name;
            private int role;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getRole() {
                return role;
            }

            public void setRole(int role) {
                this.role = role;
            }
        }

        public static class ListRoadBean {
            /**
             * id : 1
             * roadType : Major Road
             */

            private int id;
            private String roadType;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getRoadType() {
                return roadType;
            }

            public void setRoadType(String roadType) {
                this.roadType = roadType;
            }
        }

        public static class ListSHGBean {
            /**
             * id : null
             * shgName : null
             * shgCode : 10788
             * shgType : N
             * entityCode : 3121002014001
             * groupName : JAI MATA DI
             * meetingFrequency : M
             * shg_category : NOtherSHG
             * shg_active : Y
             */

            private int id;
            private String shgName;
            private String shgCode;
            private String shgType;
            private String entityCode;
            private Long villageId;
            private String groupName;
            private String meetingFrequency;
            private String shg_category;
            private String shg_active;


            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getShgName() {
                return shgName;
            }

            public void setShgName(String shgName) {
                this.shgName = shgName;
            }

            public String getShgCode() {
                return shgCode;
            }

            public void setShgCode(String shgCode) {
                this.shgCode = shgCode;
            }

            public String getShgType() {
                return shgType;
            }

            public void setShgType(String shgType) {
                this.shgType = shgType;
            }

            public String getEntityCode() {
                return entityCode;
            }

            public void setEntityCode(String entityCode) {
                this.entityCode = entityCode;
            }

            public String getGroupName() {
                return groupName;
            }

            public void setGroupName(String groupName) {
                this.groupName = groupName;
            }

            public String getMeetingFrequency() {
                return meetingFrequency;
            }

            public void setMeetingFrequency(String meetingFrequency) {
                this.meetingFrequency = meetingFrequency;
            }

            public String getShg_category() {
                return shg_category;
            }

            public void setShg_category(String shg_category) {
                this.shg_category = shg_category;
            }

            public String getShg_active() {
                return shg_active;
            }


            public Long getVillageId() {
                return villageId;
            }

            public void setVillageId(Long villageId) {
                this.villageId = villageId;
            }

            public void setShg_active(String shg_active) {
                this.shg_active = shg_active;
            }
        }

        public static class ListSocialGroupBean {
            /**
             * id : 1
             * name : SC
             */

            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class ListHotspotPointBean {
            /**
             * id : 1
             * name : Auto Stand
             */

            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class ListRejectionReasonBean {
            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class ListStateBean {
            /**
             * stateId : 31
             * stateCode : 31
             * stateName : UTTAR PRADESH
             * stateShortName : UP
             */

            private Long stateId;
            private String stateCode;
            private String stateName;
            private String stateShortName;

            public Long getStateId() {
                return stateId;
            }

            public void setStateId(Long stateId) {
                this.stateId = stateId;
            }

            public String getStateCode() {
                return stateCode;
            }

            public void setStateCode(String stateCode) {
                this.stateCode = stateCode;
            }

            public String getStateName() {
                return stateName;
            }

            public void setStateName(String stateName) {
                this.stateName = stateName;
            }

            public String getStateShortName() {
                return stateShortName;
            }

            public void setStateShortName(String stateShortName) {
                this.stateShortName = stateShortName;
            }
        }

        public static class ListHotspotSizeBean {
            /**
             * id : 1
             * name : Large
             */

            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class ListReligionBean {
            /**
             * id : 1
             * name : Hinduism
             */

            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class ListEnterpriseCensusMarketBean {
            /**
             * id : 1
             * market : Small Market
             */

            private int id;
            private String market;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMarket() {
                return market;
            }

            public void setMarket(String market) {
                this.market = market;
            }
        }

        public static class ListFieldOfficerBean {
            /**
             * id : 1
             * name : field officer 1
             */

            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class ListDistrictBean {
            /**
             * districtId : 3121
             * districtCode : 3121
             * districtName : FIROZABAD
             * stateCode : 31
             * districtShortName : FI
             */

            private Long districtId;
            private String districtCode;
            private String districtName;
            private String stateCode;
            private String districtShortName;

            public Long getDistrictId() {
                return districtId;
            }

            public void setDistrictId(Long districtId) {
                this.districtId = districtId;
            }

            public String getDistrictCode() {
                return districtCode;
            }

            public void setDistrictCode(String districtCode) {
                this.districtCode = districtCode;
            }

            public String getDistrictName() {
                return districtName;
            }

            public void setDistrictName(String districtName) {
                this.districtName = districtName;
            }

            public String getStateCode() {
                return stateCode;
            }

            public void setStateCode(String stateCode) {
                this.stateCode = stateCode;
            }

            public String getDistrictShortName() {
                return districtShortName;
            }

            public void setDistrictShortName(String districtShortName) {
                this.districtShortName = districtShortName;
            }
        }

        public static class ListCasteBean {
            /**
             * id : 1
             * name : SC
             */

            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class ListGramPanchayatBean {

            private Long grampanchayatId;
            private String grampanchayatCode;
            private String grampanchayatName;
            private String stateCode;
            private String districtCode;
            private String blockCode;

            public ListGramPanchayatBean() {
            }

            public ListGramPanchayatBean(String grampanchayatName) {
                this.grampanchayatName = grampanchayatName;
            }

            public Long getGrampanchayatId() {
                return grampanchayatId;
            }

            public void setGrampanchayatId(Long grampanchayatId) {
                this.grampanchayatId = grampanchayatId;
            }

            public String getGrampanchayatCode() {
                return grampanchayatCode;
            }

            public void setGrampanchayatCode(String grampanchayatCode) {
                this.grampanchayatCode = grampanchayatCode;
            }

            public String getGrampanchayatName() {
                return grampanchayatName;
            }

            public void setGrampanchayatName(String grampanchayatName) {
                this.grampanchayatName = grampanchayatName;
            }

            public String getStateCode() {
                return stateCode;
            }

            public void setStateCode(String stateCode) {
                this.stateCode = stateCode;
            }

            public String getDistrictCode() {
                return districtCode;
            }

            public void setDistrictCode(String districtCode) {
                this.districtCode = districtCode;
            }

            public String getBlockCode() {
                return blockCode;
            }

            public void setBlockCode(String blockCode) {
                this.blockCode = blockCode;
            }
        }

        public static class ListEnterpriseCensusSizeBean {
            /**
             * id : 1
             * size : Small
             */

            private int id;
            private String size;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSize() {
                return size;
            }

            public void setSize(String size) {
                this.size = size;
            }
        }

        public static class DayBookExpenses {
            /**
             * id : 1
             * size : Small
             */

            private Long id;
            private String name;
            public DayBookExpenses() {

            }

            public DayBookExpenses(String expensesName) {
                this.name = expensesName;
            }

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public String getExpensesName() {
                return name;
            }

            public void setExpensesName(String expensesName) {
                this.name = expensesName;
            }
        }
        public static class DayBookCategoryItems {
            /**
             * id : 1
             * size : Small
             */

            private Long id;
            private String name;

            public DayBookCategoryItems(String name) {
                this.name = name;
            }

            public DayBookCategoryItems() {
            }

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public String getExpensesName() {
                return name;
            }

            public void setExpensesName(String expensesName) {
                this.name = expensesName;
            }
        }
        public static class DayBookCashInflow {
            /**
             * id : 1
             * size : Small
             */

            private Long id;
            private String name;

            public DayBookCashInflow(String expensesName) {
                this.name=expensesName;
            }
            public DayBookCashInflow() {

            }

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public String getExpensesName() {
                return name;
            }

            public void setExpensesName(String expensesName) {
                this.name = expensesName;
            }
        }
        public static class DayBookCashOutflow {
            /**
             * id : 1
             * size : Small
             */

            private Long id;
            private String name;

            public DayBookCashOutflow(String expensesName) {
                this.name=expensesName;
            }
            public DayBookCashOutflow() {

            }

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public String getExpensesName() {
                return name;
            }

            public void setExpensesName(String expensesName) {
                this.name = expensesName;
            }
        }

    }

}