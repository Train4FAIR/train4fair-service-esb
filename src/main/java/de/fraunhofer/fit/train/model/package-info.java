// Package level annotation


@javax.xml.bind.annotation.XmlSchema(xmlns =  {

//		@javax.xml.bind.annotation.XmlNs(prefix = "xmlns", namespaceURI = "http://datacite.org/schema/kernel-4"),

		@javax.xml.bind.annotation.XmlNs(prefix = "xsi", namespaceURI = "http://www.w3.org/2001/XMLSchema-instance"),

		@javax.xml.bind.annotation.XmlNs(prefix = "schemaLocation", namespaceURI = "http://datacite.org/schema/kernel-4 http://schema.datacite.org/meta/kernel-4.1/metadata.xsd")
		

}

)

package de.fraunhofer.fit.train.model;
