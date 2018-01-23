package org.clulab.wm

import org.scalatest._

import org.clulab.odin.Attachment
import org.clulab.odin.Mention

class AgroTest extends FlatSpec with Matchers

/**
  * These are the functions that we'll be testing, that import from PaperReader
  */

//val eeWithActionsAndGlobal = ExtractorEngine(rules, myActions, myGlobalAction)
object TestUtils {
  val agroSystem = new AgroSystem()

  def extractMentions(text: String): Vector[Mention] = agroSystem.extractFrom(text)
  
  
  def newNodeSpec(nodeText: String, attachments: Set[Attachment]) =
      new NodeSpec(nodeText, attachments)
  def newNodeSpec(nodeText: String, attachments: Attachment*) =
      new NodeSpec(nodeText, attachments.toSet)
  
  def newEdgeSpec(cause: NodeSpec, effect: NodeSpec) =
      new EdgeSpec(cause, effect)
  
  
  def newQuantification(quantifier: String) =
      new Quantification(quantifier)
  
  def newDecrease(trigger: String) =
      new Decrease(trigger, None)
  def newDecrease(trigger: String, quantifiers: String*) =
      new Decrease(trigger, Option(quantifiers.toSeq))
          
  def newIncrease(trigger: String) =
      new Increase(trigger, None)
  def newIncrease(trigger: String, quantifiers: String*) =
      new Increase(trigger, Option(quantifiers.toSeq))        
}
