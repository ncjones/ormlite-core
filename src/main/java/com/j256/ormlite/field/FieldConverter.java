package com.j256.ormlite.field;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.j256.ormlite.db.BaseDatabaseType;

/**
 * Convert a Java object into the appropriate argument to a SQL statement and then back from the result set to the Java
 * object. This allows databases to configure per-type conversion. This is used by the
 * {@link BaseDatabaseType#getFieldConverter(FieldType)} method to find the converter for a particular database type.
 * Databases can then override the default data conversion mechanisms as necessary.
 * 
 * @author graywatson
 */
public interface FieldConverter {

	/**
	 * Convert a Java object and return the appropriate argument to a SQL statement.
	 */
	public Object javaToArg(Object javaObject) throws SQLException;

	/**
	 * Return the object extracted from the resultSet associated with column in position columnPos.
	 * 
	 * @throws SQLException
	 *             If there is a problem accessing the ResultSet data.
	 */
	public Object resultToJava(FieldType fieldType, ResultSet resultSet, int columnPos) throws SQLException;

	/**
	 * Return the SQL type that is stored in the database for this argument. This should be one of the {@link Types}
	 * constants.
	 */
	public int getJdbcTypeVal();
}