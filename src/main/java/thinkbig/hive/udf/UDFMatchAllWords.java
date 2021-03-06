/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright 2011 Think Big Analytics.
 */

package thinkbig.hive.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.BooleanWritable;
import org.apache.hadoop.io.Text;

import thinkbig.hive.udf.MatchUDFUtil.MatchType;

// break pattern phrase into words and then match
// if all the words found => return true, ow return false
public final class UDFMatchAllWords extends UDF {  
  public BooleanWritable evaluate(final Text text, final Text pattern) {
    if (text == null || pattern == null) { return null; }
    return new BooleanWritable(MatchUDFUtil.match(text.toString(), pattern.toString(), "keyword", MatchType.AllWords));
  }
}
