package net.pincette.jsontoxml;

import static javax.json.Json.createParser;
import static javax.xml.stream.XMLOutputFactory.newFactory;

import javax.xml.stream.XMLEventWriter;
import net.pincette.xml.stream.JsonEventReader;

public class Convert {
  @SuppressWarnings("squid:S106") // We're not logging.
  public static void main(final String[] args) throws Exception {
    final XMLEventWriter writer = newFactory().createXMLEventWriter(System.out);

    writer.add(new JsonEventReader(createParser(System.in)));
    writer.close();
  }
}
