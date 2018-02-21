package org.clulab.wm.eidos.demo.examples

import scala.collection.Seq

import org.clulab.serialization.json.stringify
import org.clulab.wm.eidos.EidosSystem
import org.clulab.wm.eidos.serialization.json.{JLDCorpus, WMJSONSerializer}
import org.clulab.wm.eidos.utils.DisplayUtils.displayMention

object ExtractFromText extends App {

  val text = "Water trucking has decreased due to the cost of fuel."

  // Initialize the reader
  val reader = new EidosSystem()

  // Extract the mentions
  val annotatedDocument = reader.extractFrom(text)

  // If you want to have a pretty display:
  annotatedDocument.mentions.foreach(displayMention)

  // You can export to JSON-LD:
  val corpus = new JLDCorpus(Seq(annotatedDocument), reader)
  val mentionsJSONLD = corpus.serialize()
  println(stringify(mentionsJSONLD, pretty = true))

  // Or... optionally you can serialize to regular JSON (e.g., if you want to later reload the mentions for post-processing)
  val mentionsJSON = WMJSONSerializer.jsonAST(annotatedDocument.mentions)
  println(stringify(mentionsJSON, pretty = true))

}