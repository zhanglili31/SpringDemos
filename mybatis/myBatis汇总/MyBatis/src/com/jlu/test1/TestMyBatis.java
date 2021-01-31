package com.jlu.test1;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jlu.test2.MyClassMapper;
import com.jlu.test2.PersonMapper;
import com.jlu.test3.Person2Mapper;
public class TestMyBatis {
	public static void main(String[] args) throws Exception {
				
				switch(2) {
				case 1:testCrud(1); break;
				case 2:testImpCrud(11);break;
				
				}
		
	}
	//参数i用于指定执行哪一个操作
	public static void testImpCrud(int i) throws IOException {
				//conf.xml - > reader
				Reader reader = Resources.getResourceAsReader("conf.xml") ;
				//reader  ->SqlSession
				//可以通过build的第二参数 指定数据库环境
				SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(reader,"development") ;
				SqlSession session = sessionFacotry.openSession() ;
				PersonMapper personMapper = session.getMapper( PersonMapper.class);
				Person2Mapper person2Mapper=session.getMapper(Person2Mapper.class);
				MyClassMapper myClassMapper=session.getMapper(MyClassMapper.class);
				switch(i) {
						//查询操作 接口
				case 1:	Person person=personMapper.queryPersonById(4);
						System.out.println(person);break;
						//删除	接口
				case 2: personMapper.deletePersonById(3);session.commit();break;
						//插入	接口
				case 3: personMapper.insertPerson(new Person(5,"c1 str8","c2 str 8",true,1,5));session.commit();break;
						//修改	接口
				case 4: personMapper.updatePersonById(new Person(4,"c1 str4",  "str4 c2",true));session.commit();break;
						//select use converter
				case 5: System.out.println(personMapper.selectPersonByIdWithConverter(4));break;
						//update use converter
				case 6: personMapper.updatePersonByIdWithConveter(new Person(4,"str1","str2",false));session.commit();break;
						// 使用hashmap获取一条数据
				case 7: Map<String,Object>  hashMap=personMapper.queryPersonByIdReturnHashMap(4);
						System.out.println(hashMap);break;
						//使用HashMap 和 List获取多条数据
				case 8: List<HashMap<String,Object>> listTable=personMapper.queryPersonByIdReturnTable();
						System.out.println(listTable);break;
						//使用动态sql查询
				case 9: System.out.println(personMapper.queryPersonDynamic(new Person(4,null,"str",false,1,2)));break;
						//10 一对一查询
				case 10: System.out.println(person2Mapper.selectAllPersonWithCard());break;
						//一对多查询  一个班级对多个学生
				case 11: List<HashMap<String,Object>> myClass=myClassMapper.selectPersonByClass();
						System.out.println(myClass);
						
						
					
				}
				
	}
	public static  void  testCrud(int i) throws IOException {
		//加载MyBatis配置文件（为了访问数据库）
				Reader reader = Resources.getResourceAsReader("conf.xml") ;
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader) ;
				//session - connection
				SqlSession session = sessionFactory.openSession();
				switch(i) {
						//1   test query 
				case 1:	String statement = "com.jlu.test2.PersonMapper.queryPersonById" ;
						Person person = session.selectOne( statement,4 ) ;
						System.out.println(person);
						break;
						//2   test insert 
				case 2:	String statement2="com.jlu.test2.PersonMapper.insertPerson";
						session.insert(statement2, new Person(7,"c1 str","s2 str2",true,1,4));
						session.commit();//必须执行提交否则不会把数据更新到数据里 ,即使执行session.close();
						session.close();
						System.out.println("insert date successfully ");
						break;
						//3		test delete
				case 3:	String statement3="com.jlu.test2.PersonMapper.deletePersonById";
						session.delete(statement3,6);
						session.commit();
						break;
						//4 test update
				case 4: String statement4="com.jlu.test2.PersonMapper.updatePersonById";
						session.update(statement4, new Person(4,"hi Gay","im fine",true,2,4));
						session.commit();
						break;
					
				}
	}
}
