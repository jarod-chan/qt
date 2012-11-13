package cn.fyg.qt.application.impl;

import org.springframework.stereotype.Service;

import cn.fyg.qt.application.AdminService;
import cn.fyg.qt.domain.model.admin.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	@Override
	public boolean check(String name, String password) {
		return Admin.admin.check(name, password);
	}

}
