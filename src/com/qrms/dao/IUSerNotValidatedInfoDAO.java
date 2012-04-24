package com.qrms.dao;

import java.util.List;
import com.qrms.bean.UserNotValidatedInfo;

/**
 * Descroption:The interface of the UserNotValidtedInfoDAO
 * 
 * @author Zhaolu & Yinshunming
 * @version 1.0
 */

public interface IUSerNotValidatedInfoDAO {

	public void save(UserNotValidatedInfo unv);

	public List<UserNotValidatedInfo> findByLoginEmail(String loginEmail);

	public List<UserNotValidatedInfo> findByEncryptkey(Object encryptkey);

	public void delete(UserNotValidatedInfo persistentInstance);
}
