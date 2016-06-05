package com.fate.restful.et.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author WangGang
 * 2016年05月31日14:57:48
 */
public class IdcUser implements Serializable {
	private static final long serialVersionUID = 123456789L;
	/**
	 * 主键ID
	 */
	private long id;
	/**
	 * 创建时间
	 */
	private String gmtCreate;
	/**
	 * 修改时间
	 */
	private String gmtModified;
	/**
	 * CODE，自动生成，不可修改
	 */
	private String userCode;
	/**
	 * 姓 + 名
	 */
	private String userName;
	/**
	 * 邮箱，用于登录
	 */
	private String userMail;
	/**
	 * 密码
	 */
	private String userPwd;
	/**
	 * 手机
	 */
	private String userPhone;
	/**
	 * 用户等级
	 * default:normal
	 */
	private String userLevel;
	/**
	 * 用户组
	 * default:basic
	 */
	private String userGroup;
	/**
	 * 删除标志
	 * y=已删除
	 * n=正常
	 */
	private String isDeleted;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public String getGmtModified() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		try {
//			System.out.println(sdf.format(gmtModified));
//			System.out.println(sdf.parse(sdf.format(gmtModified)));
//			return sdf.parse(sdf.format(gmtModified));
//		} catch (ParseException e) {
////			e.printStackTrace();
//			return gmtModified;
//		}
		return gmtModified;
	}
	public void setGmtModified(String gmtModified) {
		this.gmtModified = gmtModified;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	public String getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
