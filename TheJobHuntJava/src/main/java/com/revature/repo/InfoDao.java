package com.revature.repo;

import com.revature.models.Information;
import com.revature.models.User;

public interface InfoDao {

	
/*
 * insert info
update info
select info by id
﻿delete info
 */
	
	boolean insertInfo(Information info);
	boolean updateInfo(Information info);
	Information selectInfo(Information u);
	boolean deleteInfo(Information u);
	
	
}
