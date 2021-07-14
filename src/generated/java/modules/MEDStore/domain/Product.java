package modules.MEDStore.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.skyve.CORE;
import org.skyve.domain.messages.DomainException;
import org.skyve.impl.domain.AbstractPersistentBean;

/**
 * Product
 * 
 * @navhas n supplier 1 Supplier
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class Product extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "MEDStore";

	/** @hidden */
	public static final String DOCUMENT_NAME = "Product";

	/** @hidden */
	public static final String namePropertyName = "name";

	/** @hidden */
	public static final String quantityPropertyName = "quantity";

	/** @hidden */
	public static final String supplierPropertyName = "supplier";

	/**
	 * Name
	 **/
	private String name;

	/**
	 * Quantity
	 **/
	private Integer quantity;

	/**
	 * Supplier
	 **/
	private Supplier supplier = null;

	@Override
	@XmlTransient
	public String getBizModule() {
		return Product.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return Product.DOCUMENT_NAME;
	}

	public static Product newInstance() {
		try {
			return CORE.getUser().getCustomer().getModule(MODULE_NAME).getDocument(CORE.getUser().getCustomer(), DOCUMENT_NAME).newInstance(CORE.getUser());
		}
		catch (RuntimeException e) {
			throw e;
		}
		catch (Exception e) {
			throw new DomainException(e);
		}
	}

	@Override
	@XmlTransient
	public String getBizKey() {
		try {
			return org.skyve.util.Binder.formatMessage("Product - {quantity}", this);
		}
		catch (@SuppressWarnings("unused") Exception e) {
			return "Unknown";
		}
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof Product) && 
					this.getBizId().equals(((Product) o).getBizId()));
	}

	/**
	 * {@link #name} accessor.
	 * @return	The value.
	 **/
	public String getName() {
		return name;
	}

	/**
	 * {@link #name} mutator.
	 * @param name	The new value.
	 **/
	@XmlElement
	public void setName(String name) {
		preset(namePropertyName, name);
		this.name = name;
	}

	/**
	 * {@link #quantity} accessor.
	 * @return	The value.
	 **/
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * {@link #quantity} mutator.
	 * @param quantity	The new value.
	 **/
	@XmlElement
	public void setQuantity(Integer quantity) {
		preset(quantityPropertyName, quantity);
		this.quantity = quantity;
	}

	/**
	 * {@link #supplier} accessor.
	 * @return	The value.
	 **/
	public Supplier getSupplier() {
		return supplier;
	}

	/**
	 * {@link #supplier} mutator.
	 * @param supplier	The new value.
	 **/
	@XmlElement
	public void setSupplier(Supplier supplier) {
		if (this.supplier != supplier) {
			preset(supplierPropertyName, supplier);
			this.supplier = supplier;
		}
	}
}
