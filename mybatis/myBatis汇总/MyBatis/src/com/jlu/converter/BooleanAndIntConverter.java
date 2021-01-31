package com.jlu.converter;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
//BaseTypeHandler<java����>
public class BooleanAndIntConverter extends	BaseTypeHandler<Boolean>  {
	//java(boolean)-DB(number)
		/*
		 * arg0 ps:PreparedStatement����
		 * arg1 i��PreparedStatement�������������λ��
		 * arg2 parameter:javaֵ
		 * arg3 jdbcType��jdbc���������ݿ�����
		 */
	@Override
	public void setNonNullParameter(PreparedStatement arg0, int arg1, Boolean arg2, JdbcType arg3) throws SQLException {
		// TODO Auto-generated method stub
		if(arg2) {
			arg0.setInt(arg1, 1);
		}else {
			arg0.setInt(arg1, 0);
		}
		
	}
	//db(number)->java(boolean)
	@Override
	public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		int i=rs.getInt(columnName);
		return (i==1)? true:false; 
	}

	@Override
	public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		int sexNum = rs.getInt(columnIndex) ;//rs.getInt(1)
		return sexNum == 1?true:false ;
	
	}

	@Override
	public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		int sexNum = cs.getInt(columnIndex) ;//rs.getInt(1)
		return sexNum == 1?true:false ;
	}



}
