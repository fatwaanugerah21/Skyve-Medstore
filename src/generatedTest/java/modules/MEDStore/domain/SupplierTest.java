package modules.MEDStore.domain;

import org.skyve.util.DataBuilder;
import org.skyve.util.test.SkyveFixture.FixtureType;
import util.AbstractDomainTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractDomainTest} to create your own tests for this document.
 */
public class SupplierTest extends AbstractDomainTest<Supplier> {

	@Override
	protected Supplier getBean() throws Exception {
		return new DataBuilder()
			.fixture(FixtureType.crud)
			.build(Supplier.MODULE_NAME, Supplier.DOCUMENT_NAME);
	}
}