package com.CareGiver.config;

import java.util.Locale;
import java.util.Map;

import com.CareGiver.domains.Customer;
import com.CareGiver.domains.Provider;
import com.CareGiver.domains.User;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;
import io.cucumber.datatable.TableTransformer;

/*
 * Maps datatables in feature files to custom domain objects.
 */
public class DataTableConfigurer implements TypeRegistryConfigurer {

	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}

	private final TableEntryTransformer<Customer> customersEntryTransformer = new TableEntryTransformer<Customer>() {
		@Override
		public Customer transform(Map<String, String> tableEntry) {
			return Customer.createCustomer(tableEntry);
		}
	};

	private final TableEntryTransformer<Provider> singleProviderTransformer = new TableEntryTransformer<Provider>() {
		@Override
		public Provider transform(Map<String, String> tableEntry) throws Throwable {
			// Map<String, String> tableEntry = table.asMaps().get(0);
			return Provider.createProvider(tableEntry);
		}

	};

	private final TableEntryTransformer<User> userTransformer = new TableEntryTransformer<User>() {
		@Override
		public User transform(Map<String, String> tableEntry) throws Throwable {
			System.err.println(tableEntry.toString());
			return User.createUser(tableEntry);
		}

	};

	@Override
	public void configureTypeRegistry(TypeRegistry typeRegistry) {
		typeRegistry.defineDataTableType(new DataTableType(Customer.class, customersEntryTransformer));
		typeRegistry.defineDataTableType(new DataTableType(Provider.class, singleProviderTransformer));
		typeRegistry.defineDataTableType(new DataTableType(User.class, userTransformer));
	}

}