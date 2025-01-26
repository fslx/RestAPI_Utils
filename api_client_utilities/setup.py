from setuptools import setup, find_packages

setup(
    name="api_client_utilities",
    version="1.0.0",
    description="Lightweigth portable Python script module for sending HTTP calls to self-created RestAPI as well as stress testing different API endpoints",
    author="fslx",
    author_email=None, #
    packages=find_packages(),
    install_requires=["request>=2.26.0",],
    entry_points={
        "console_scripts": [
            "api-client=api_client_utilities:main",
        ]
    }
)