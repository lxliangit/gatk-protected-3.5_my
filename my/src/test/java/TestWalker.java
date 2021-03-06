/*
* Copyright 2012-2015 Broad Institute, Inc.
*
* Permission is hereby granted, free of charge, to any person
* obtaining a copy of this software and associated documentation
* files (the "Software"), to deal in the Software without
* restriction, including without limitation the rights to use,
* copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the
* Software is furnished to do so, subject to the following
* conditions:
*
* The above copyright notice and this permission notice shall be
* included in all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
* EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
* OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
* NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
* HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
* WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
* FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR
* THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

import org.broadinstitute.gatk.engine.walkers.WalkerTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Collections;

/**
 * NOTE: Currently the testing infrastructure for walkers does not support running outside the Broad.
 */
public class TestWalker extends WalkerTest {

    @Test
    public void testMyReadAttrWalker() throws URISyntaxException {
        // String gatk_args = String.format("-T MyExampleWalker -I %s -R %s", getResource("/exampleBAM.bam"), getResource("/exampleFASTA.fasta"));
        String gatk_args = String.format("-T ReadAttrWalker -I %s ", getResource("/test.bam"));
        WalkerTestSpec spec = new WalkerTestSpec(gatk_args, Collections.<String>emptyList());
        executeTest("Testing print BI attribute on the example bam", spec);
    }

    private File getResource(String path) throws URISyntaxException {
        return new File(publicTestDir, path);
        /*
        TODO: Enable proper resource extraction from the test jars. For now just use the publicTestDir path.
        URL resourceUrl = getClass().getResource(path);
        if (resourceUrl == null)
            throw new MissingResourceException("Resource not found: " + path, getClass().getSimpleName(), path);
        return new File(resourceUrl.toURI());
         */
    }
}
