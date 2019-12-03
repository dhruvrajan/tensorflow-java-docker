/*
 Copyright 2019 The TensorFlow Authors. All Rights Reserved.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 =======================================================================
 */
package org.tensorflow.util.ndarray.impl.dense;

import org.tensorflow.util.ndarray.IntNdArrayTestBase;
import org.tensorflow.util.buffer.DataBuffer;
import org.tensorflow.util.buffer.DataBuffers;
import org.tensorflow.util.ndarray.IntNdArray;
import org.tensorflow.util.ndarray.NdArrays;
import org.tensorflow.util.ndarray.Shape;

public class IntDenseNdArrayTest extends IntNdArrayTestBase {

  @Override protected IntNdArray allocate(Shape shape) {
    return NdArrays.ofInts(shape);
  }

  @Override protected DataBuffer<Integer> allocateBuffer(long size) {
    return DataBuffers.ofInts(size);
  }
}