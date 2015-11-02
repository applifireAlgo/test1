Ext.define('Helloworld.helloworld.shared.com.helloworld.model.authentication.UserModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "userId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "userAccessCode",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "useraccesslevelid",
          "reference": "UserAccessLevel",
          "defaultValue": ""
     }, {
          "name": "useraccessdomainid",
          "reference": "UserAccessDomain",
          "defaultValue": ""
     }, {
          "name": "multiFactorAuthEnabled",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "genTempOneTimePassword",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "allowMultipleLogin",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "isLocked",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "isDeleted",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "changePasswordNextLogin",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "passwordExpiryDate",
          "type": "date",
          "defaultValue": ""
     }, {
          "name": "passwordAlgo",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "lastPasswordChangeDate",
          "type": "date",
          "defaultValue": ""
     }, {
          "name": "sessionTimeout",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "UserData",
          "reference": "UserDataModel"
     }, {
          "name": "PassRecovery",
          "reference": "PassRecoveryModel"
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});