package com.seleniumexpress.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.seleniumexpress.models.AccessCard;
import com.seleniumexpress.models.Employee;
import com.seleniumexpress.utils.HibernateUtils;

/**
 * Hello world!
 *
 */
public class StudentApp {

	private static Session session = null;

	public static void main(String[] args) {

		// 1. create configuration
		// 2. create session factory
		// 3. initialize the session object

		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();

		Transaction transaction = session.getTransaction();

		transaction.begin();
		/*
		 * AccessCard accessCard = session.get(AccessCard.class, 1);
		 * accessCard.getEmployee().setAccessCard(null);
		 */
		// session.delete(accessCard);

		Employee employee = session.get(Employee.class, 1);

		System.out.println("Employee Name :::: " + employee.getName());
		System.out.println(" Access Card :::: " + employee.getAccessCard().getAccessCardNumber());
		transaction.commit();

		session.close();
		sessionFactory.close();

	}

}
