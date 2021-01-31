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
	//����i����ָ��ִ����һ������
	public static void testImpCrud(int i) throws IOException {
				//conf.xml - > reader
				Reader reader = Resources.getResourceAsReader("conf.xml") ;
				//reader  ->SqlSession
				//����ͨ��build�ĵڶ����� ָ�����ݿ⻷��
				SqlSessionFactory sessionFacotry = new SqlSessionFactoryBuilder().build(reader,"development") ;
				SqlSession session = sessionFacotry.openSession() ;
				PersonMapper personMapper = session.getMapper( PersonMapper.class);
				Person2Mapper person2Mapper=session.getMapper(Person2Mapper.class);
				MyClassMapper myClassMapper=session.getMapper(MyClassMapper.class);
				switch(i) {
						//��ѯ���� �ӿ�
				case 1:	Person person=personMapper.queryPersonById(4);
						System.out.println(person);break;
						//ɾ��	�ӿ�
				case 2: personMapper.deletePersonById(3);session.commit();break;
						//����	�ӿ�
				case 3: personMapper.insertPerson(new Person(5,"c1 str8","c2 str 8",true,1,5));session.commit();break;
						//�޸�	�ӿ�
				case 4: personMapper.updatePersonById(new Person(4,"c1 str4",  "str4 c2",true));session.commit();break;
						//select use converter
				case 5: System.out.println(personMapper.selectPersonByIdWithConverter(4));break;
						//update use converter
				case 6: personMapper.updatePersonByIdWithConveter(new Person(4,"str1","str2",false));session.commit();break;
						// ʹ��hashmap��ȡһ������
				case 7: Map<String,Object>  hashMap=personMapper.queryPersonByIdReturnHashMap(4);
						System.out.println(hashMap);break;
						//ʹ��HashMap �� List��ȡ��������
				case 8: List<HashMap<String,Object>> listTable=personMapper.queryPersonByIdReturnTable();
						System.out.println(listTable);break;
						//ʹ�ö�̬sql��ѯ
				case 9: System.out.println(personMapper.queryPersonDynamic(new Person(4,null,"str",false,1,2)));break;
						//10 һ��һ��ѯ
				case 10: System.out.println(person2Mapper.selectAllPersonWithCard());break;
						//һ�Զ��ѯ  һ���༶�Զ��ѧ��
				case 11: List<HashMap<String,Object>> myClass=myClassMapper.selectPersonByClass();
						System.out.println(myClass);
						
						
					
				}
				
	}
	public static  void  testCrud(int i) throws IOException {
		//����MyBatis�����ļ���Ϊ�˷������ݿ⣩
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
						session.commit();//����ִ���ύ���򲻻�����ݸ��µ������� ,��ʹִ��session.close();
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
